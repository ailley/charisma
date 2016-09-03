package com.w3cmart.service.roleMenu;

import com.w3cmart.entity.roleMenu.RoleMenu;
import com.w3cmart.entity.roleMenu.RoleMenuCriteria;
import com.w3cmart.entity.rolePermission.RolePermissionCriteria;
import com.w3cmart.mapper.roleMenu.RoleMenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService{

    @Resource
    private RoleMenuMapper roleMenuMapper;

    public int insert(RoleMenu roleMenu) {
        return roleMenuMapper.insert(roleMenu);
    }

    public int delete(Long id) {
        return roleMenuMapper.deleteByPrimaryKey(id);
    }

    public int deleteByExampler(RoleMenuCriteria roleMenuCriteria) {
        return roleMenuMapper.deleteByExample(roleMenuCriteria);
    }

    public List<RoleMenu> selectByExample(RoleMenuCriteria roleMenuCriteria) {
        return roleMenuMapper.selectByExample(roleMenuCriteria);
    }
}
