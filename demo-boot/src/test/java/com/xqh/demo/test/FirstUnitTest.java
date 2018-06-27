package com.xqh.demo.test;

import com.xqh.demo.DemoApplication;
import com.xqh.demo.service.user.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xqh on 2018/6/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class FirstUnitTest {
    @Autowired(required = true)
    private UserService userService;

    @Test
    public void sayHello() {
        System.out.println("hello");
    }

    @Test
    public void userService() {
        Assert.assertNotNull(userService);
    }
}
