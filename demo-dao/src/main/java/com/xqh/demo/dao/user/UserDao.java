package com.xqh.demo.dao.user;

import com.xqh.demo.entity.user.User;

import java.util.List;

/**
 * Created by xqh on 2018/2/4.
 */
public interface UserDao {
    List<User> getAll();
}
