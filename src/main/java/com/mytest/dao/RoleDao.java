package com.mytest.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
//@Repository
public interface RoleDao extends BaseDao {

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
