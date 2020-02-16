package com.graduation.self_check_in_system.interceptor;

/**
 * Created by huangds on 2017/10/24.
 */

import com.graduation.self_check_in_system.WebSecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录配置
 */
@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
        String url = "";
//            判断是否已有用户登录的session
        if (session.getAttribute(WebSecurityConfig.SESSION_KEY) != null) {
            return true;
        } else {
            //跳转到登录页
            url = "/login.html";
            response.sendRedirect(url);
            return false;
        }
//
    }
}

