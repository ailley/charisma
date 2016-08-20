package com.w3cmart.service.user;

import com.w3cmart.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/13.
 */
public interface UserService {
    /**
     * 根据当前登录用户名查询用户信息
     * @param userName
     * @return
     */
    User queryUserByUserName(String userName);

    /**
     * 查询所有用户信息
     * @return
     */
    List<Map<String,Object>> selectUserInfo();

    int insert(User user);
}
