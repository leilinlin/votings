package com.cssl.controller;


import com.cssl.pojo.Users;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    //控制层自动专配服务层
    @Autowired
    private UserService userService;

    @RequestMapping("/regist")
    public String regist(Users user) {
        String url = "";
        if (userService.regisUsers(user)) {
            System.out.println("我注册成功了！！！！");
            //注册成功重定向到登录页
            url = "login";
        } else {
            url = "regist";
        }
        return  url;
    }

    @RequestMapping("/login")
    public String login(Users user, HttpSession session){
        System.out.println("login:");
       Users users = userService.loginUser(user);
       System.out.println(users.getUsername());

       if(users!=null){
           session.setAttribute("Users",users);

           return "forward:/voteList";
       }
       return "redirect:/login.html";
    }

}