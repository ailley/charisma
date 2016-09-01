package com.w3cmart.service.role;

import com.w3cmart.entity.role.Role;
import com.w3cmart.entity.role.RoleCriteria;

import java.util.List;

/**
 * Created by Administrator on 2016/9/1.
 */
public interface RoleService {

    int addRole(Role role);

    int updateRole(Role role);

    int delete(Long id);

    List<Role> selectExample(RoleCriteria roleCriteria);
}
