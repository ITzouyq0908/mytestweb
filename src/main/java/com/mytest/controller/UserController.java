package com.mytest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytest.pojo.User;
import com.mytest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午10:01 2017/12/1
 */
@Controller
@RequestMapping("/user")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/showUser1", method = RequestMethod.POST)
    public String toIndex(HttpServletRequest request, Model model) {
        System.out.println("af: " + request.getParameter("userId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.getUserById(userId);
        System.out.println("userName: " + user.getUserName());
        model.addAttribute("user", user);
//        return null;
        return "pages/showUser";
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.POST)
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int userId = Integer.parseInt(request.getParameter("userId"));
        logger.info("userId:" + userId);
        User user = this.userService.getUserById(userId);
        logger.info("user:" + user);

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();

    }

    /**
     * 直接返回字符串
     * @param teamname
     * @param request
     * @return
     */
    @RequestMapping(value = "v1/new/{teamname}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserMsg(@PathVariable String teamname, HttpServletRequest request) {
        //可以使用teamname获取url路径分隔

        //获取请求参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        User user = new User();
        user.setUserName(teamname);
        user.setAge(Integer.parseInt(age));
        return user.getUserName();
    }

    /**
     * 直接返回对象，自动转化为JSON格式
     * @param teamname
     * @param request
     * @return
     */
    @RequestMapping(value = "v2/new/{teamname}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable String teamname, HttpServletRequest request) {
        //可以使用teamname获取url路径分隔

        //获取请求的参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        User user = new User();
        user.setUserName(teamname);
        user.setAge(Integer.parseInt(age));
        return user;
    }

    @RequestMapping(value = "v3/new/{teamname}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(@PathVariable String teamname, HttpServletRequest request) {
        //可以使用teamname获取url路径分隔

        //获取请求的参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        User user = new User();
        user.setUserName(teamname);
        user.setAge(Integer.parseInt(age));

        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user);
        return users;
    }


}
