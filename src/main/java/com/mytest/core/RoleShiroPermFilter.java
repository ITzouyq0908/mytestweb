package com.mytest.core;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 */
public class RoleShiroPermFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        String[] permsArray = (String[]) o;
        //没有权限限制
        if (permsArray == null || permsArray.length == 0) {
            return true;
        }
        for (int i = 0; i < permsArray.length; i++) {
            //如果是角色，就是subject.hasRole()
            //若当前用户是permsArray中的任何一个，则有权限访问
            if (subject.isPermitted(permsArray[i])) {
                return true;
            }
        }
        return false;
    }
}
