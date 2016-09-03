package com.w3cmart.service.rolePermission;

import com.w3cmart.entity.role.RoleCriteria;
import com.w3cmart.entity.rolePermission.RolePermission;
import com.w3cmart.entity.rolePermission.RolePermissionCriteria;
import com.w3cmart.mapper.rolePermission.RolePermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService{

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    public int insertRolePermission(RolePermission rolePermission) {
        return rolePermissionMapper.insert(rolePermission);
    }

    public int delete(Long id) {
        return rolePermissionMapper.deleteByPrimaryKey(id);
    }

    public int deleteByExampler(RolePermissionCriteria rolePermissionCriteria) {
        return rolePermissionMapper.deleteByExample(rolePermissionCriteria);
    }

    public List<RolePermission> selectByExampler(RolePermissionCriteria rolePermissionCriteria) {
        return rolePermissionMapper.selectByExample(rolePermissionCriteria);
    }
}
