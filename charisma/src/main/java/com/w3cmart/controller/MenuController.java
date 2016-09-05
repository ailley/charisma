package com.w3cmart.controller;

import com.w3cmart.common.enums.StatusEnum;
import com.w3cmart.common.util.ViewResult;
import com.w3cmart.entity.menu.Menu;
import com.w3cmart.entity.menu.MenuCriteria;
import com.w3cmart.entity.roleMenu.RoleMenu;
import com.w3cmart.entity.roleMenu.RoleMenuCriteria;
import com.w3cmart.entity.user.User;
import com.w3cmart.entity.user.UserCriteria;
import com.w3cmart.service.menu.MenuService;
import com.w3cmart.service.roleMenu.RoleMenuService;
import com.w3cmart.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/17.
 */
@Controller
public class MenuController {


    @Resource
    private MenuService menuService;

    @RequestMapping("menu")
    @RequiresPermissions("visit:menu")
    public String toMenu(){
        return "menu";
    }

    @RequestMapping("selelctMenu")
    @ResponseBody
    @RequiresPermissions("select:menu")
    public String selectMenu(){
        MenuCriteria menuCri = new MenuCriteria();
        MenuCriteria.Criteria cri =menuCri.createCriteria();
        cri.andParentIdEqualTo(0L);
        List<Menu> list = menuService.selectByExample(menuCri);
        for (Menu menu : list) {
            MenuCriteria menuCriteria =new MenuCriteria();
            MenuCriteria.Criteria criteria =menuCriteria.createCriteria();
            criteria.andParentIdEqualTo(menu.getId());
            menu.setNodes( menuService.selectByExample(menuCriteria));
        }
        return ViewResult.newInstance().rows(list).json();
    }

    @RequestMapping("addRootMenu")
    @ResponseBody
    @RequiresPermissions("add:rootMenu")
    public String addRootMenu(Menu menu){
        menu.setStatus(StatusEnum.ENABLE);
        menu.setParentId(0L);
        menuService.addRootMenu(menu);
        return ViewResult.newInstance().json();
    }

    @RequestMapping("selectSubMenu")
    @ResponseBody
    public Map selectSubMenu(Long parentId){
        Map map = new HashMap();
        MenuCriteria menuCriteria = new MenuCriteria();
        MenuCriteria.Criteria criteria = menuCriteria.createCriteria();
        if(parentId!=null ){
            criteria.andParentIdEqualTo(parentId);
        }
        List<Menu> list = menuService.selectByExample(menuCriteria);
        map.put("data",list);
        return map;
    }

    @RequestMapping("addMenu")
    @ResponseBody
    @RequiresPermissions("add:menu")
    public String addMenu(Menu menu){
        menu.setStatus(StatusEnum.ENABLE);
        menuService.addRootMenu(menu);
        return ViewResult.newInstance().json();
    }
    @RequestMapping("updateMenu")
    @ResponseBody
    @RequiresPermissions("update:menu")
    public String updateMenu(Menu menu){
        menuService.updateMenu(menu);
        return ViewResult.newInstance().json();
    }
    @RequestMapping("deleteMenu")
    @ResponseBody
    @RequiresPermissions("delete:menu")
    public String deleteMenu(Long id){
        menuService.deleteMenu(id);
        return ViewResult.newInstance().json();
    }
    @RequestMapping("removeRoot")
    @ResponseBody
    public String removeRoot(Long rootId){
        MenuCriteria menuCriteria = new MenuCriteria();
        MenuCriteria.Criteria criteria = menuCriteria.createCriteria();
        criteria.andParentIdEqualTo(rootId);
        List<Menu> menuList = menuService.selectByExample(menuCriteria);
        for (Menu menu : menuList) {
            menuService.deleteMenu(menu.getId());
        }
        menuService.deleteMenu(rootId);
        return ViewResult.newInstance().json();
    }
    @RequestMapping("showMenu")
    @ResponseBody
    public String showMenu(){
        String subject = (String)SecurityUtils.getSubject().getPrincipal();
        List<Menu> list = menuService.selectByUserName(subject);
        return ViewResult.newInstance().rows(list).json();
    }

}
