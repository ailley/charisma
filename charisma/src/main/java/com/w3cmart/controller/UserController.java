package com.w3cmart.controller;

import com.w3cmart.common.enums.StatusEnum;
import com.w3cmart.common.util.UUIDGenerator;
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
    @RequestMapping("updatetUser")
    @ResponseBody
    public int insertUser(User user){
        user.setUid(UUIDGenerator.generate(user));
        user.setStatus(StatusEnum.ENABLE);
        user.setCreateTime(System.currentTimeMillis());
        userService.update(user);
        return 1;
    }
}
