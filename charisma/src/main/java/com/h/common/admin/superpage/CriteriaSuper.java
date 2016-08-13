package com.h.common.admin.superpage;

/**
 * Created by Administrator on 2016/8/13.
 */

public abstract interface CriteriaSuper
{
    public abstract void setTop(int paramInt);

    public abstract void setSkipCount(int paramInt);

    public abstract void setOrderByClause(String paramString);

    public abstract String getOrderByClause();
}