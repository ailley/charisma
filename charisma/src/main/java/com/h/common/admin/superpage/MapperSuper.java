package com.h.common.admin.superpage;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public  interface MapperSuper {

    int countByExample(CriteriaSuper paramCriteriaSuper);

    List<BeanSuper> selectByExample(CriteriaSuper paramCriteriaSuper);
}
