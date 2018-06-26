package com.xqh.demo.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by xqh on 2018/6/26.
 */
public class MyAdviceFilter extends AdviceFilter {

    private static final Logger logger = LogManager.getLogger(MyAdviceFilter.class);

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        logger.info("AdviceFilter preHandle");
        Subject subject= SecurityUtils.getSubject();

        if (!subject.isAuthenticated()) {
            AccessAuthenticationToken token = new AccessAuthenticationToken("test","f418463d-09d2-47cf-802d-5f7e2ed7b19e");
            subject.login(token);
        }

        return true;
    }

    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
        logger.info("AdviceFilter postHandle");
    }

    @Override
    public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception) throws Exception {
        logger.info("AdviceFilter afterCompletion");
    }
}
