package com.w3cmart.controller;

import com.w3cmart.common.enums.StatusEnum;
import com.w3cmart.common.util.ViewResult;
import com.w3cmart.entity.menu.Menu;
import com.w3cmart.entity.menu.MenuCriteria;
import com.w3cmart.entity.permission.Permission;
import com.w3cmart.entity.permission.PermissionCriteria;
import com.w3cmart.entity.role.Role;
import com.w3cmart.entity.roleMenu.RoleMenu;
import com.w3cmart.entity.roleMenu.RoleMenuCriteria;
import com.w3cmart.entity.rolePermission.RolePermission;
import com.w3cmart.entity.rolePermission.RolePermissionCriteria;
import com.w3cmart.service.menu.MenuService;
import com.w3cmart.service.permission.PermissionService;
import com.w3cmart.service.roleMenu.RoleMenuService;
import com.w3cmart.service.rolePermission.RolePermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/31.
 */
@Controller
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @Resource
    private MenuService menuService;

    @Resource
    private RolePermissionService rolePermissionService;

    @Resource
    private RoleMenuService roleMenuService;

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
    @RequestMapping("selelctPermissionByRoleId")
    @ResponseBody
    public String selelctPermissionByRoleId(Long  roleId){

        Map state = new HashMap();
        state.put("checked",true);

        RolePermissionCriteria rolePermissionCriteria = new RolePermissionCriteria() ;
        RolePermissionCriteria.Criteria rolePermissiontCri = rolePermissionCriteria.createCriteria();
        rolePermissiontCri.andRoleIdEqualTo(roleId);
        List<RolePermission> rolePermissionList = rolePermissionService.selectByExampler(rolePermissionCriteria);

        RoleMenuCriteria roleMenuCriteria = new RoleMenuCriteria();
        RoleMenuCriteria.Criteria roleMenuCri = roleMenuCriteria.createCriteria();
        roleMenuCri.andRoleIdEqualTo(roleId);
        List<RoleMenu> roleMenuList = roleMenuService.selectByExample(roleMenuCriteria);

        MenuCriteria menuCri = new MenuCriteria();
        MenuCriteria.Criteria cri =menuCri.createCriteria();
        cri.andParentIdEqualTo(0L);
        List<Menu> list = menuService.selectByExample(menuCri);
        for (Menu menu : list) {
            MenuCriteria menuCriteria =new MenuCriteria();
            MenuCriteria.Criteria criteria =menuCriteria.createCriteria();
            criteria.andParentIdEqualTo(menu.getId());
            List<Menu> menuList=menuService.selectByExample(menuCriteria);
            for (RoleMenu roleMenu : roleMenuList) {
                System.out.println(menu.getId() + "!!!!!!!!!!!!!"+ roleMenu.getMenuId());
                if(menu.getId().equals(roleMenu.getMenuId())){
                    menu.setState(state);
                }
            }
            menu.setSelectable(false);
            menu.setNodes(menuList);

            for (Menu menuSub : menuList) {
                List<Menu> menuPermissionList = new ArrayList<Menu>();
                PermissionCriteria permissionCriteria = new PermissionCriteria();
                PermissionCriteria.Criteria criteriaPermission = permissionCriteria.createCriteria();
                criteriaPermission.andMenuIdEqualTo(menuSub.getId());
                List<Permission> permissionList = permissionService.selectByExampler(permissionCriteria);
                for (Permission permission : permissionList) {
                    Menu menuPermission = new Menu();
                    for (RolePermission rolePermission : rolePermissionList) {
                        if(permission.getId().equals(rolePermission.getPermissionId())){
                            menuPermission.setState(state);
                        }
                    }
                    menuPermission.setParentId(menuSub.getId());
                    menuPermission.setId(permission.getId());
                    menuPermission.setText(permission.getPermissionDes());
                    menuPermission.setSelectable(false);
                    menuPermissionList.add(menuPermission);
                }
                for (RoleMenu roleMenu : roleMenuList) {
                    System.out.println(menuSub.getId() + "!!!!!!!!!!!!!"+ roleMenu.getMenuId());
                    if(menuSub.getId().equals(roleMenu.getMenuId())){
                        menuSub.setState(state);
                    }
                }
                menuSub.setSelectable(false);
                menuSub.setNodes(menuPermissionList);
            }
        }

        return ViewResult.newInstance().rows(list).json();
    }

    @RequestMapping("addRoleAndPermission")
    @ResponseBody
    public String addRoleAndPermission(String roleId,String menuId,String permissionId){
        String [] menuIds = null ;
        if(menuId!=null && menuId!=""){
            menuIds = menuId.split(",");
        }
        String [] permissions = null ;
        if(permissionId!=null && permissionId!=""){
            permissions = permissionId.split(",");
        }

        RoleMenuCriteria roleMenuCriteria =new RoleMenuCriteria();
        RoleMenuCriteria.Criteria  criteriaRole =roleMenuCriteria.createCriteria();
        criteriaRole.andRoleIdEqualTo(Long.valueOf(roleId));
        roleMenuService.deleteByExampler(roleMenuCriteria);

        RolePermissionCriteria rolePermissionCriteria = new RolePermissionCriteria();
        RolePermissionCriteria.Criteria criteria =rolePermissionCriteria.createCriteria();
        criteria.andRoleIdEqualTo(Long.valueOf(roleId));
        rolePermissionService.deleteByExampler(rolePermissionCriteria);

        if(menuIds!=null){
            for (String menu : menuIds) {
                RoleMenu roleMenu =new RoleMenu();
                roleMenu.setRoleId(Long.valueOf(roleId));
                roleMenu.setMenuId(Long.valueOf(menu));
                roleMenuService.insert(roleMenu);
            }
        }

        if(permissions!=null){
            for (String s : permissions) {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(Long.valueOf(roleId));
                rolePermission.setPermissionId(Long.valueOf(s));
                rolePermissionService.insertRolePermission(rolePermission);
            }
        }

        return ViewResult.newInstance().json();
    }
}
