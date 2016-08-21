package com.w3cmart.realm;

import com.w3cmart.entity.User;
import com.w3cmart.entity.UserCriteria;
import com.w3cmart.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 13708 on 2016/8/15.
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    /**
     * 权限认证
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        //查出是否有此用户
        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria criteria = userCriteria.createCriteria();
        criteria.andUserNameEqualTo(token.getUsername().toLowerCase());
        List<User> userList=userService.selectByExample(userCriteria);

        if (userList.size()==0) {
            throw new UnknownAccountException();// 没找到帐号
        }
        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userList.get(0).getUserName(), // 用户名
                userList.get(0).getPassword(), // 密码
                getName()// realm name
        );
        return authenticationInfo;
    }
}
