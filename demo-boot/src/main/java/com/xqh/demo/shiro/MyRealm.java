package com.xqh.demo.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xqh on 2018/6/25.
 */
public class MyRealm extends AuthorizingRealm {

    private static final Logger logger = LogManager.getLogger(MyRealm.class);

    @Override
    public Class getAuthenticationTokenClass() {
        return AccessAuthenticationToken.class;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo");

        //TODO 通过用户获取权限
        
        Set<String> setPermissions = new HashSet<>();
        setPermissions.add("query");
        setPermissions.add("add");


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(setPermissions);
//        info.setRoles(null);
//        info.setObjectPermissions(null);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo");

        AccessAuthenticationToken accessAuthenticationToken = (AccessAuthenticationToken) token;
        String accessToken = accessAuthenticationToken.getAccessToken();
        String userToken = accessAuthenticationToken.getUserToken();

        //TODO 对比用户信息

        return new SimpleAuthenticationInfo(userToken, accessToken, getName());
    }
}
