package com.xqh.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by xqh on 2018/6/25.
 */
public class MyAccessControlFilter extends AccessControlFilter {
    @Override
    public boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object object) throws Exception{
        return false;
    }


    @Override
    public boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception{
        Subject subject= SecurityUtils.getSubject();

        if (!subject.isAuthenticated()) {
            AccessAuthenticationToken token = new AccessAuthenticationToken("test","f418463d-09d2-47cf-802d-5f7e2ed7b19e");
            subject.login(token);
        }

        return true;
    }
}
