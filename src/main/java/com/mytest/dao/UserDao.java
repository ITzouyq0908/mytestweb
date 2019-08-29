package com.mytest.dao;

import com.mytest.pojo.User;

public interface UserDao extends BaseDao{
    /**
     * 根据用户ID获取用户信息
     * @return
     */
    User getUserById(int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    void modfireUserById(User user);

    void insertUser(User user);

    Integer countByExample();
}
