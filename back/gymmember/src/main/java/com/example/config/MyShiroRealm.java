package com.example.config;

import com.example.dao.userDao;
import com.example.model.user;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private userDao userDAO; // 假设你已经有了一个DAO来获取用户信息

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userid = (String) principals.getPrimaryPrincipal();
        user us = userDAO.selectUserAccount(userid);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole(us.getType()); // 假设User类有一个获取角色的方法

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userid = (String) token.getPrincipal();
        user us = userDAO.selectUserAccount(userid);

        if(us != null) {
            return new SimpleAuthenticationInfo(us.getAccount(), us.getPasswd(), getName());
        }

        return null;
    }
}
