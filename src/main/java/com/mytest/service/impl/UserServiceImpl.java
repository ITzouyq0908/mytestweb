package com.mytest.service.impl;

import com.mytest.dao.UserDao;
import com.mytest.pojo.User;
import com.mytest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void modfireUserById(User user) {
        userDao.modfireUserById(user);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public Integer countByExample() {
        return userDao.countByExample();
    }
}
