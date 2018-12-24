package com.mytest.core;

import com.mytest.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //根据自己的需求编写获取授权信息
        Integer userId = (Integer)principalCollection.fromRealm(getName()).iterator().next();
        SimpleAuthorizationInfo info = null;
        if(userId != null) {
            List<String > perms = roleService.getPermissionByUserId(userId);
            if(perms != null && !perms.isEmpty()) {
                info = new SimpleAuthorizationInfo();
                for (String each : perms) {
                    //将权限资源添加到用户信息中
                    info.addStringPermission(each);
                }
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        SimpleAuthenticationInfo info = null;
        //通过表单接收用户名，调用
        String userName = token.getUsername();
        if(StringUtils.isNotEmpty(userName)) {
            //查询密码
            String password = roleService.getPasswordByUserName(userName);
            if(StringUtils.isNotEmpty(password)) {
                info = new SimpleAuthenticationInfo(userName, password, getName());
            }
        }
        return info;
    }
}
