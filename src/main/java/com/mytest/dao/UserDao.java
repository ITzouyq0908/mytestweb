package com.mytest.dao;

import com.mytest.pojo.User;
import org.springframework.stereotype.Repository;

//@Repository("userDao")
public interface UserDao extends BaseDao{
    /**
     * 根据用户ID获取用户信息
     * @return
     */
    public User getUserById(int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public User modfireUserById(User user);

    public void insertUser(User user);

    Integer countByExample();
}
