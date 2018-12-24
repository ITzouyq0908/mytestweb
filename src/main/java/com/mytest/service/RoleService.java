package com.mytest.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 */
public interface RoleService {

    /**
     * 登录
     * @param username
     * @param password
     */
    void doLogin(String username, String password) throws Exception;

    /**
     * 根据用户名查询密码
     * @param userName
     * @return
     */
    String getPasswordByUserName(String userName);

    /**
     * 根据用户ID查询当前的权限
     * @param userId
     * @return
     */
    List<String> getPermissionByUserId(Integer userId);
}
