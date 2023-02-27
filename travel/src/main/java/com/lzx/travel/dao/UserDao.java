package com.lzx.travel.dao;

import com.lzx.travel.domain.User;

public interface UserDao {

    public User findByUsername(String username);  //根据用户名查询用户信息

    public void save(User user);  //用户保存

    User findByCode(String code);  //根据激活码查询用户对象

    void updateStatus(User user);  //修改指定用户激活状态

    User findByUsernameAndPassword(String username, String password);  //根据用户名和密码查询的方法
}
