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

    /**
     * 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可。
     * onAccessDenied是否执行取决于isAccessAllowed的值，如果返回true则onAccessDenied不会执行；如果返回false，执行onAccessDenied
     * 如果onAccessDenied也返回false，则直接返回，不会进入请求的方法（只有isAccessAllowed和onAccessDenied的情况下）
     * */
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
