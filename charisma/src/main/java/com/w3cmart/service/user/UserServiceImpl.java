package com.w3cmart.service.user;

import com.w3cmart.dao.user.UserDao;
import com.w3cmart.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/8/13.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public User queryUserByUserName(String userName) {
        return userDao.queryUserByUserName(userName);
    }
}
