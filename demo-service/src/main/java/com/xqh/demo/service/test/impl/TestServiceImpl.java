package com.xqh.demo.service.test.impl;

import com.xqh.demo.service.test.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by xqh on 2017/10/6.
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    public String sayHello() {
        return "hello spring boot and cxf";
    }
}
