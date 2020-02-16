package com.graduation.self_check_in_system.controller;

import com.graduation.self_check_in_system.WebSecurityConfig;
import com.graduation.self_check_in_system.modal.Student;
import com.graduation.self_check_in_system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY)String account, Model model){

        return "/index.html";
    }
    //登录
    @RequestMapping("/login")
    @ResponseBody
    public String Back(@RequestBody Student student, HttpServletRequest request) {
        String failLogin = "fail";
        String successLogin = "success";
        System.out.println("录取编号：" + student.getAdm_num() + "-------密码:" + student.getPassword());
        //验证信息
        boolean pass = loginService.loginVerify(student,request.getSession());
        if (pass) {
            return successLogin;
        }
        else {
            return failLogin;
        }
    }

    //注销登录
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session){
        //清除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        session.removeAttribute("status");
        return "logout";
    }

}
