package com.w3cmart.service.user;

import com.w3cmart.entity.user.User;
import com.w3cmart.entity.user.UserCriteria;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/8/13.
 */
public interface UserService {

    List<User> selectByExample(UserCriteria userCriteria);

    int insert(User user);

    int update(User user);

    String selectRoleByUserName(String userName);

    List<String> selectPermissionByUserName(String userName);
}
