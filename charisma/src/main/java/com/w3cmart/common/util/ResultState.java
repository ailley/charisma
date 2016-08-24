package com.w3cmart.common.util;

/**
 * Created by Administrator on 2016/8/24.
 */
public class ResultState
{
    public final int state;
    public final String messge;

    public ResultState(int state, String message)
    {
        this.state = state;
        this.messge = message;
    }
}