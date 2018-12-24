package com.mytest.service;

import com.mytest.pojo.User;

public interface UserService {
    /**
     * 根据用户ID获取用户信息
     *
     * @return
     */
    public User getUserById(int id);

    public void insertUser(User user);

    public User modfireUserById(User user);

    Integer countByExample();

}
