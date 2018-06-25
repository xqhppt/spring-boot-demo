package com.xqh.demo.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by xqh on 2018/6/25.
 */
public class AccessAuthenticationToken implements AuthenticationToken {
    private String userToken;
    private String accessToken;

    public AccessAuthenticationToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AccessAuthenticationToken(String userToken, String accessToken) {
        this(accessToken);
        this.userToken = userToken;
    }

    @Override
    public Object getPrincipal() {
        return userToken;
    }

    @Override
    public Object getCredentials() {
        return accessToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
