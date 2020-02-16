package com.graduation.self_check_in_system.interceptor;

/**
 * @program: self_check_in_system
 * @description:
 * @author: peng yu bin
 * @create: 2020-02-08 15:23
 */

import com.graduation.self_check_in_system.WebSecurityConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: self_check_in_system
 * @description:
 * @author: peng yu bin
 * @create: 2020-02-08 15:05
 */
@Component
    public class LoginedInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
//            判断是否已有用户登录的session
        if(session.getAttribute(WebSecurityConfig.SESSION_KEY) == null){
            return true;
        }

        //跳转到主页
        String url = "/index.html";
        response.sendRedirect(url);
        return false;

//
    }
}
