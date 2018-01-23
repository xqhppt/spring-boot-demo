package com.xqh.demo.web.api.test;

import com.xqh.demo.enttiy.test.TestEntity;
import com.xqh.demo.service.test.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by xqh on 2017/10/3.
 */
@Path("/test")
//@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces({MediaType.APPLICATION_JSON})
//@Produces({MediaType.APPLICATION_XML})
@Controller
@Api(tags = "测试", description = "测试相关")
public class TestController {

    @Autowired
    private TestService testService;

    @GET
    @Path("/hi")
    @ApiOperation(value = "hi", response = String.class)
    public String hi() {
        return testService.sayHello();
    }

    @GET
    @Path("/json")
    @ApiOperation(value = "测试JSON", response = TestEntity.class)
    @Produces("application/json")
    public TestEntity testJson() {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(11L);
        testEntity.setDesc("json object");
        testEntity.setDate(new Date());

        return testEntity;
    }
}
