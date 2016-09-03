package com.w3cmart.service.rolePermission;

import com.w3cmart.entity.role.RoleCriteria;
import com.w3cmart.entity.rolePermission.RolePermission;
import com.w3cmart.entity.rolePermission.RolePermissionCriteria;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface RolePermissionService {

    int insertRolePermission(RolePermission rolePermission);

    int delete(Long id);

    int deleteByExampler(RolePermissionCriteria rolePermissionCriteria);

    List<RolePermission> selectByExampler(RolePermissionCriteria rolePermissionCriteria);
}
