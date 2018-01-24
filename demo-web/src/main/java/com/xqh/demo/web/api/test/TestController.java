package com.xqh.demo.web.api.test;

import com.xqh.demo.web.api.test.vo.HelloVo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String sayHello() {
        return "Hello,World!";
    }

    @RequestMapping(path = "/hello/{name}",method = RequestMethod.GET)
    public String sayHelloTo(@PathVariable("name") String name){
        return "Hello," + name;
    }

    @RequestMapping(path = "/hello",method = RequestMethod.POST,consumes = "application/json")
    public HelloVo addHello(@RequestBody HelloVo helloVo){
        return helloVo;
    }

    @RequestMapping(path = "/msg",method = RequestMethod.GET,params = {"p1","p2=2"})
    public String getMsg(){
        return "请求参数包含p1，p2=2才可以访问";
    }
}
