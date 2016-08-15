package com.h.common.admin.superpage;

/**
 * Created by Administrator on 2016/8/13.
 */

public abstract interface CriteriaSuper
{
     void setTop(int paramInt);

    void setSkipCount(int paramInt);

    void setOrderByClause(String paramString);

    String getOrderByClause();
}