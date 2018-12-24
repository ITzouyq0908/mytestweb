package com.mytest.service.impl;

import com.mytest.dao.RoleDao;
import com.mytest.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void doLogin(String username, String password) throws Exception {

        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //是否记住用户
            token.setRememberMe(true);
            try {
                //执行登录
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                throw new Exception("账户不存在");
            } catch (IncorrectCredentialsException ice) {
                throw new Exception("账户密码不正确");
            } catch (LockedAccountException lae) {
                throw new Exception("账户被锁定");
            } catch (AuthenticationException ae) {
                throw new Exception("未知错误");
            }
        }

    }

    @Override
    public String getPasswordByUserName(String userName) {
        return roleDao.getPasswordByUserName(userName);
    }

    @Override
    public List<String> getPermissionByUserId(Integer userId) {
        return roleDao.getPermissionByUserId(userId);
    }
}
