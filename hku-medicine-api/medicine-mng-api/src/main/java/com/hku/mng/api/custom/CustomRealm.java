package com.hku.mng.api.custom;

import com.hku.mng.api.entity.User;
import com.hku.mng.api.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Set;

/**
 * @author pengzhengfa
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principals.getPrimaryPrincipal();
        /**
         * 根据用户名查询用户角色和权限
         */
        Set<String> roles = userService.getUserRoles(username);
        Set<String> permissions = userService.getUserPermissions(username);
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.getUserByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            throw new UnknownAccountException("用户不存在");
        }
        return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
    }
}
