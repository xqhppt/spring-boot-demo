package com.xqh.demo.web.api.user;

import com.xqh.demo.entity.user.User;
import com.xqh.demo.service.user.UserService;
import com.xqh.demo.web.api.user.vo.UserVO;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xqh on 2018/2/4.
 */
@RestController
@RequestMapping(path = "/user", produces = "application/json")
@Api(tags = "用户", description = "用户相关API")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LogManager.getLogger(UserController.class);

    //@RequiresAuthentication
    @RequiresPermissions("add")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<UserVO> getAll() {
        List<UserVO> list = new ArrayList<>();
        List<User> users = userService.getAll();

        if (!CollectionUtils.isEmpty(users)) {
            for (User item : users) {
                UserVO userVO = new UserVO();
                BeanUtils.copyProperties(item,userVO);
                list.add(userVO);
            }
        }

        logger.info("this is info log");
        logger.warn("this is warn log");
        logger.error("this is error log");

        return list;
    }
}
