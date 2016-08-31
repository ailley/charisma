package com.w3cmart.controller;

import com.w3cmart.common.enums.StatusEnum;
import com.w3cmart.common.util.ViewResult;
import com.w3cmart.entity.permission.Permission;
import com.w3cmart.entity.permission.PermissionCriteria;
import com.w3cmart.service.permission.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 */
@Controller
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @RequestMapping("addPermission")
    @ResponseBody
    public  String addPermission(Permission permission){
        permission.setCreateDate(System.currentTimeMillis());
        permission.setStatus(StatusEnum.ENABLE);
        permissionService.insert(permission);
        return ViewResult.newInstance().json();
    }

    @RequestMapping("updatePermission")
    @ResponseBody
    public  String updatePermission(Permission permission){
        permission.setUpdeteDate(System.currentTimeMillis());
        permissionService.update(permission);
        return ViewResult.newInstance().json();
    }

    @RequestMapping("selectPermission")
    @ResponseBody
    public String selectPermission(Long menuId){
        PermissionCriteria permissionCriteria = new PermissionCriteria();
        PermissionCriteria.Criteria criteria = permissionCriteria.createCriteria();
        criteria.andMenuIdEqualTo(menuId);
        List permissionList = permissionService.selectByExampler(permissionCriteria);
        return ViewResult.newInstance().rows(permissionList).json();
    }

    @RequestMapping("delPermission")
    @ResponseBody
    public String delPermission(Long id){
        permissionService.delete(id);
        return ViewResult.newInstance().json();
    }

}
