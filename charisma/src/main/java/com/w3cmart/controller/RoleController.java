package com.w3cmart.controller;

import com.w3cmart.common.enums.StatusEnum;
import com.w3cmart.common.util.ViewResult;
import com.w3cmart.entity.role.Role;
import com.w3cmart.entity.role.RoleCriteria;
import com.w3cmart.service.role.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/9/1.
 */
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("role")
    @RequiresPermissions("visit:role")
    public String toRole(){
        return "role";
    }

    @RequestMapping("selectRole")
    @ResponseBody
    public String selectRole(){
        List<Role> list = roleService.selectExample(new RoleCriteria());
        return ViewResult.newInstance().rows(list).json();
    }

    @RequestMapping("insertRole")
    @ResponseBody
    public String insertRole(Role role){
        role.setStatus(StatusEnum.ENABLE);
        roleService.addRole(role);
        return ViewResult.newInstance().json();
    }

    @RequestMapping("updateRole")
    @ResponseBody
    public String updateRole(Role role){
        roleService.updateRole(role);
        return ViewResult.newInstance().json();
    }

    @RequestMapping("deleteRole")
    @ResponseBody
    public String deleteRole(Long id){
        roleService.delete(id);
        return ViewResult.newInstance().json();
    }
}
