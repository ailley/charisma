package com.w3cmart.dao.user;

import com.w3cmart.mapper.user.UserMapper;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2016/8/13.
 */

public class UserDaoImpl implements UserDao{

    @Resource
    private UserMapper userMapper;

}
