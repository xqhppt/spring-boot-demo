package com.xqh.demo.web.api.user;

import com.xqh.demo.entity.user.User;
import com.xqh.demo.service.user.UserService;
import com.xqh.demo.web.api.user.vo.UserVO;
import io.swagger.annotations.Api;
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

        return list;
    }
}
