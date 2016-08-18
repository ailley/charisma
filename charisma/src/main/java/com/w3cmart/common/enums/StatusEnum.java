package com.w3cmart.common.enums;

/**
 * Created by Administrator on 2016/8/13.
 */
public enum StatusEnum
        implements ShowAble, ITypeEnum<StatusEnum, Byte>
{
    ENABLE( 0, "有效"),
    DISABLE(1, "无效");

    public final int value;
    public final String show;


    StatusEnum(int value, String show) {
        this.value = value;
        this.show = show;
    }

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