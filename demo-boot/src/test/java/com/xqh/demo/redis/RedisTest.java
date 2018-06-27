package com.xqh.demo.redis;

import com.xqh.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xqh on 2018/6/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void testString() {
        stringRedisTemplate.opsForValue().set("a", "123");
    }

    @Test
    public void testList() {
        Long v = stringRedisTemplate.opsForList().leftPush("list", "1");
        System.out.println(v);
    }
}
