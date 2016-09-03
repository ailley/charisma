package com.w3cmart.service.permission;

import com.w3cmart.entity.permission.Permission;
import com.w3cmart.entity.permission.PermissionCriteria;

import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 */
public interface PermissionService {

    int insert(Permission permission);

    int update(Permission permission);

    int delete(Long id);

    int deleteByExampler(PermissionCriteria permissionCriteria);

    List<Permission> selectByExampler(PermissionCriteria permissionCriteria);
}
