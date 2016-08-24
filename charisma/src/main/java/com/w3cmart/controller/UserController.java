package com.w3cmart.controller;

import com.w3cmart.common.enums.StatusEnum;
import com.w3cmart.common.util.UUIDGenerator;
import com.w3cmart.common.util.ViewResult;
import com.w3cmart.entity.User;
import com.w3cmart.entity.UserCriteria;
import com.w3cmart.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/18.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("user")
    public String toUser(){
        return "user";
    }

    @RequestMapping("selectUserInfo")
    @ResponseBody
    public Map<String,List<User>> selectUserInfo(){
        Map<String, List<User>> map = new HashMap<String, List<User>>();
        UserCriteria userCriteria = new UserCriteria();
        map.put("data",userService.selectByExample(userCriteria));
        return map;
    }
    @RequestMapping("insertUser")
    @ResponseBody
    public String insertUser(User user){
        user.setUid(UUIDGenerator.generate(user));
        user.setStatus(StatusEnum.ENABLE);
        user.setPassword("123456");
        user.setCreateTime(System.currentTimeMillis());
        userService.insert(user);
        return ViewResult.newInstance().json();
    }
    @RequestMapping("updatetUser")
    @ResponseBody
    public String updateUser(User user){
        user.setUpdateTime(System.currentTimeMillis());
        userService.update(user);

        return ViewResult.newInstance().json();
    }
    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(Long id){
        User user = new User();
        user.setId(id);
        user.setStatus(StatusEnum.DISABLE);
        userService.update(user);
        return ViewResult.newInstance().json();
    }
}
