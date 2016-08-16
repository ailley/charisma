package com.w3cmart.service.user;

import com.w3cmart.dao.user.UserDao;
import com.w3cmart.entity.User;
import com.w3cmart.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/8/13.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    public User queryUserByUserName(String userName) {
        return userMapper.queryUserByUserName(userName);
    }
}
