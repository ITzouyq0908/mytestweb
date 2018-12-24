package com.mytest.service;

import com.mytest.dao.RoleDao;
import com.mytest.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration("classpath:spring-mybatis.xml")*/
@ContextConfiguration("classpath:applicationContext.xml")
public class RoleTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void queryUserByUserIdTest() {
        String password = roleService.getPasswordByUserName("");
        System.out.println(password);
    }

}
