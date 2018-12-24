package com.mytest.pojo;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Date;

public class User {

    private Integer id;

    private String userName;

    private String password;

    private Integer age;

    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        try {
            return  BeanUtils.describe(this).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}