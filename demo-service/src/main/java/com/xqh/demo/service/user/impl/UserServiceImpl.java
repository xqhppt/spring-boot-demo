package com.xqh.demo.service.user.impl;

import com.xqh.demo.dao.user.UserDao;
import com.xqh.demo.entity.user.User;
import com.xqh.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xqh on 2018/2/4.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
