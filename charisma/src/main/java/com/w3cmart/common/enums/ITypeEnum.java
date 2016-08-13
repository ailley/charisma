package com.w3cmart.common.enums;

/**
 * Created by Administrator on 2016/8/13.
 */
public  interface ITypeEnum<T, V>
{
    StatusEnum getEnumInstance(V paramV);
}
