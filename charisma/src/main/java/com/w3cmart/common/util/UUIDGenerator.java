package com.w3cmart.common.util;

import java.net.InetAddress;
import java.security.SecureRandom;

/**
 * UUID工具类，用来产生一个唯一的标记号UUID
 */
public class UUIDGenerator {
    private static SecureRandom SEEDER_STATIC = null;
    private static byte[] ADDRESS             = null;
    private static String MID_VALUE_STATIC    = null;
    private String midValue = null;
    private SecureRandom seeder = null;

    static {
        try {
            ADDRESS = InetAddress.getLocalHost().getAddress();
            StringBuffer buffer = new StringBuffer(8);
            buffer.append(toHex(toInt(ADDRESS), 8));
            MID_VALUE_STATIC = buffer.toString();
            SEEDER_STATIC = new SecureRandom();
            SEEDER_STATIC.nextInt();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public UUIDGenerator() {
        StringBuffer buffer = new StringBuffer(16);
        buffer.append(MID_VALUE_STATIC);
        buffer.append(toHex(System.identityHashCode(this), 8));
        midValue = buffer.toString();
        seeder = new SecureRandom();
        seeder.nextInt();
    }

    /**
     * 该方法用来产生一个32位的唯一的标记String
     *
     * @param obj
     *            传入一个参考的对象
     * @return
     */
    public static String generate(Object obj) {
        StringBuffer uid = new StringBuffer(32);

        // get the system time
        long currentTimeMillis = System.currentTimeMillis();
        uid.append(toHex((int) (currentTimeMillis & -1L), 8));

        // get the internet address
        uid.append(MID_VALUE_STATIC);

        // get the object hash value
        uid.append(toHex(System.identityHashCode(obj), 8));

        // get the random number
        uid.append(toHex(getRandom(), 8));

        return uid.toString();
    }

    /**
     * 该方法用来产生一个32位的String唯一标记
     */
    public  String generate() {
        StringBuffer uid = new StringBuffer(32);

        // get the system time
        long currentTimeMillis = System.currentTimeMillis();
        uid.append(toHex((int) (currentTimeMillis & -1L), 8));

        // get the internet address
        uid.append(midValue);

        // get the random number
        uid.append(toHex(seeder.nextInt(), 8));

        return uid.toString();
    }

    private static String toHex(int value, int length) {
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        StringBuffer buffer = new StringBuffer(length);
        int shift = length - 1 << 2;
        for (int i = -1; ++i < length;) {
            buffer.append(hexDigits[value >> shift & 0xf]);
            value <<= 4;
        }

        return buffer.toString();
    }

    private static int toInt(byte[] bytes) {
        int value = 0;
        for (int i = -1; ++i < bytes.length;) {
            value <<= 8;
            value |= bytes[i];
        }

        return value;
    }

    private static synchronized int getRandom() {
        return SEEDER_STATIC.nextInt();
    }
}
