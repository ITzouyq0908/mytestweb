package com.mytest.service;

import com.mytest.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午2:24 2017/11/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration("classpath:spring-mybatis.xml")*/
@ContextConfiguration("classpath:spring-context.xml")
public class UserTest {

    @Autowired
    private UserService userSevice;
    @Autowired
    private SqlSessionFactoryBean sqlSessionFactory;

    @Test
    public void queryUserByUserIdTest() throws Exception {
        Field field = sqlSessionFactory.getClass().getDeclaredField("mapperLocations");
        field.setAccessible(true);
        Resource[] resources = (Resource[])field.get(sqlSessionFactory);
        System.out.println("mapperLocations: " + Arrays.toString(resources));
        User user = userSevice.getUserById(2);

        System.out.println("user: " + user);
        System.out.println("username: " + user.getUserName());
        System.out.println("password: " + user.getPassword());
    }

    @Test
    public void insertUserTest() {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("fadfaf");
        user.setAge(12);
        userSevice.insertUser(user);
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setId(1);
        user.setUserName("李四");
        user.setAge(33);
        user.setPassword("1111");
        user.setBirthday(new Date());
        userSevice.modfireUserById(user);
    }


    @Test
    public void countByExampleTest() {
        int count = userSevice.countByExample();
        System.out.println("count: " + count);
    }

    public static void main(String[] args) throws Exception{

        Class clazz = Class.forName("com.mytest.pojo.User");
        Object obj = clazz.newInstance();

        Method setMethod = clazz.getMethod("setUserName", String.class);

        setMethod.invoke(obj,"说的");

        Method method = clazz.getMethod("getUserName");
        Object val = method.invoke(obj);
        System.out.println(val);

//        PropertyDescriptor descriptor =

    }


 }
