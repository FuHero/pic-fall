package cn.server.lab.security;

import cn.server.lab.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Fu Zhong on 2015/8/14.
 */
public class MyAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 方法可以理解为是权限验证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        if (!StringUtils.hasText(username)) {
            return null;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if ("admin".equals(username)) {
            info.addRole("admin");
            info.addStringPermission("*");
            return info;
        }
        return null;
    }

    /**
     * 理解为登陆验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if (userService.login(username, password) != null) {
            return new SimpleAuthenticationInfo(username, password, super.getName());
        }
        throw new IncorrectCredentialsException();
    }
}
