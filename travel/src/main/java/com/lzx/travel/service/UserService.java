package com.lzx.travel.service;

import com.lzx.travel.domain.User;

public interface UserService {

    boolean regist(User user);  //注册用户

    boolean active(String code);  //激活用户

    User login(User user);  //登录方法
}
