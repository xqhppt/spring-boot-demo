package com.xqh.demo.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xqh on 2018/6/25.
 */
@Configuration
public class ShiroConfig {
    @Bean
    public MyRealm myShiroRealm() {
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        filtersMap.put("myAccessControlFilter", new MyAccessControlFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

        Map<String, String> map = new HashMap<String, String>();
        map.put("/**", "myAccessControlFilter");

//        //登出
//        map.put("/logout","logout");
//        //对所有用户认证
//        map.put("/**","authc");
//        //登录
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        //首页
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        //错误页面，认证不通过跳转
//        shiroFilterFactoryBean.setUnauthorizedUrl("/error");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }
}
