package com.xqh.demo.web.api.test;

import com.xqh.demo.web.api.test.vo.HelloVo;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyyMMdd"));
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam("msg") String msg) {
        return "Hello,World!" + msg;
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String sayHelloTo(@PathVariable("name") String name) {
        return "Hello," + name;
    }

    @RequestMapping(path = "/hello", method = RequestMethod.POST, consumes = "application/json")
    public HelloVo addHello(@RequestBody HelloVo helloVo) {
        return helloVo;
    }

    @RequestMapping(path = "/msg", method = RequestMethod.GET, params = {"p1", "p2=2"})
    public String getMsg() {
        return "请求参数包含p1，p2=2才可以访问";
    }

    @RequestMapping(path = "/entity", method = RequestMethod.GET)
    public String getMsgFromHeader(HttpEntity<String> requestEntity) {
        return requestEntity.getHeaders().get("my").get(0);
    }

    @RequestMapping(path = "/date", method = RequestMethod.GET)
    public Date getDate(@RequestParam("date") Date date) {
        return date;
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public HelloVo getHello() {
        HelloVo helloVo = new HelloVo();
        helloVo.setName("小王");
        helloVo.setMsg("你好");
        return helloVo;
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getError() {
        HelloVo helloVo = new HelloVo();
        helloVo = null;
        //return helloVo.getMsg();

        return String.valueOf(1 / 0);
    }
}
