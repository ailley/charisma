package com.w3cmart.common.enums;

/**
 * Created by Administrator on 2016/8/13.
 */
public enum StatusEnum
        implements ShowAble, ITypeEnum<StatusEnum, Byte>
{
    ENABLE((byte) 0, "有效"),
    DISABLE((byte) 1, "无效");

    public final byte value;
    public final String show;

    StatusEnum(byte value, String show) { this.value = value;
        this.show = show; }

    public StatusEnum getEnumInstance(Byte value)
    {
        return values()[value.byteValue()];
    }

    public int value() {
        return this.value;
    }

    public String show() {
        return this.show;
    }
}