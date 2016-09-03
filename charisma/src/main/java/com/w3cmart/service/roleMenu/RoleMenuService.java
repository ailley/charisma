package com.w3cmart.service.roleMenu;

import com.w3cmart.entity.roleMenu.RoleMenu;
import com.w3cmart.entity.roleMenu.RoleMenuCriteria;
import com.w3cmart.entity.rolePermission.RolePermissionCriteria;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface RoleMenuService {

    int insert(RoleMenu roleMenu);

    int delete(Long id);

    int deleteByExampler(RoleMenuCriteria roleMenuCriteria);

    List<RoleMenu> selectByExample(RoleMenuCriteria roleMenuCriteria);
}
