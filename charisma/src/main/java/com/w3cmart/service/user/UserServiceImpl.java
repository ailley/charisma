package com.w3cmart.service.user;

import com.w3cmart.entity.User;
import com.w3cmart.entity.UserCriteria;
import com.w3cmart.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    public List<User> selectByExample(UserCriteria userCriteria) {
        return userMapper.selectByExample(userCriteria);
    }
    public int insert(User user) {
        return userMapper.insert(user);
    }

    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
