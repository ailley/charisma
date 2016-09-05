package com.w3cmart.realm;

import com.w3cmart.entity.permission.Permission;
import com.w3cmart.entity.user.User;
import com.w3cmart.entity.user.UserCriteria;
import com.w3cmart.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        String userName = (String) principals.getPrimaryPrincipal();
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (session.getAttribute("role") == null) {
            String role = userService.selectRoleByUserName(userName);
            authorizationInfo.addRole(role);
            session.setAttribute("role", role);
        }
        if (session.getAttribute("permissions") == null) {
            List<String> permissionsList = userService.selectPermissionByUserName(userName);
            if(permissionsList != null && permissionsList.size()>0){
                authorizationInfo.addStringPermissions(permissionsList);
            }
            session.setAttribute("permissions",permissionsList.toString());
        }
        return authorizationInfo;
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
