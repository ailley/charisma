package com.w3cmart.common.base.exception;

/**
 * Created by Administrator on 2016/8/24.
 */
public class BusinessException extends RuntimeException
{
    private static final long serialVersionUID = 4908057740861418501L;
    public final int state;

    public BusinessException()
    {
        this.state = 1;
    }

    public BusinessException(Throwable e) {
        super(e);
        this.state = 1;
    }

    public BusinessException(String message) {
        super(message);
        this.state = 1;
    }

    public BusinessException(int state, String message) {
        super(message);
        this.state = state;
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
        this.state = 1;
    }

    public BusinessException(int state, String message, Throwable e) {
        super(message, e);
        this.state = state;
    }

    public String toString()
    {
        return this.state + ":" + super.toString();
    }
}
