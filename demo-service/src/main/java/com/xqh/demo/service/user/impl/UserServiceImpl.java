package com.xqh.demo.service.user.impl;

import com.xqh.demo.api.dto.user.UserDTO;
import com.xqh.demo.api.service.IUserService;
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
public class UserServiceImpl implements UserService, IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public UserDTO getUser(Long id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("Lily");
        return userDTO;
    }
}
