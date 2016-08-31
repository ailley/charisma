package com.w3cmart.service.permission;

import com.w3cmart.entity.permission.Permission;
import com.w3cmart.entity.permission.PermissionCriteria;
import com.w3cmart.mapper.permission.PermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 */
@Service
public class PermissionServiceImpl implements  PermissionService{

    @Resource
    private PermissionMapper permissionMapper;

    public int insert(Permission permission) {
        return permissionMapper.insert(permission);
    }

    public int update(Permission permission) {
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    public int delete(Long id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    public List<Permission> selectByExampler(PermissionCriteria permissionCriteria) {
        return permissionMapper.selectByExample(permissionCriteria);
    }
}
