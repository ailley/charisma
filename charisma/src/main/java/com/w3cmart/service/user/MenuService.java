package com.w3cmart.service.user;

import com.w3cmart.entity.Menu;
import com.w3cmart.entity.MenuCriteria;

import java.util.List;

/**
 * Created by Administrator on 2016/8/28.
 */
public interface MenuService {

    int addRootMenu(Menu menu);

    List<Menu> selectByExample(MenuCriteria menuCriteria);

}
