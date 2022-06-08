package com.example.controller;

import com.example.pojo.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    //在所有的界面层一定会有业务逻辑层的对象
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        Admin admin =adminService.login(name,pwd);
        if (admin != null){
            //登录成功
            request.setAttribute("admin",admin);
            return "main";
        }else {
            //登录失败
            request.setAttribute("errmsg","用户名或密码不正确");
            return "login";
        }
    }

    @RequestMapping("/query")
    public String query(String name, String pwd, HttpServletRequest request){
        Admin admin =adminService.login(name,pwd);
        if (admin != null){
            //登录成功
            request.setAttribute("admin",admin);
            return "main";
        }else {
            //登录失败
            request.setAttribute("errmsg","用户名或密码不正确");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(String name, String pwd, HttpServletRequest request){
        Admin admin =adminService.login(name,pwd);
        if (admin != null){
            //登录成功
            request.setAttribute("admin",admin);
            return "main";
        }else {
            //登录失败
            request.setAttribute("errmsg","用户名或密码不正确");
            return "login";
        }
    }
}
