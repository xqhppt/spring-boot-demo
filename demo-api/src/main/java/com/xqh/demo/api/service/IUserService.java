package com.xqh.demo.api.service;

import com.xqh.demo.api.dto.user.UserDTO;

/**
 * Created by xqh on 2018/6/23.
 */
public interface IUserService {
    UserDTO getUser(Long id);
}
