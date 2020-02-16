package com.graduation.self_check_in_system;

/**
 * Created by huangds on 2017/10/24.
 */

import com.graduation.self_check_in_system.interceptor.LoginedInterceptor;
import com.graduation.self_check_in_system.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录配置
 */
@Configuration

public class WebSecurityConfig implements WebMvcConfigurer {
    @Autowired
    private LoginedInterceptor loginedInterceptor;
    @Autowired
    private SecurityInterceptor securityInterceptor;

    public final static String SESSION_KEY = "loginName";

    public void  addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration addLoginedInterceptor = registry.addInterceptor(loginedInterceptor);
        InterceptorRegistration addSecurityInterceptor = registry.addInterceptor(securityInterceptor);

        addSecurityInterceptor.excludePathPatterns("/error");
        addSecurityInterceptor.excludePathPatterns("/login.html").
                excludePathPatterns("/register.html").
                excludePathPatterns("/login").excludePathPatterns("/check").
                excludePathPatterns("/css/**","/js/**","/img/**","/fonts/**","/icons-reference/**","/vendor/**","/data/**");
        addSecurityInterceptor.addPathPatterns("/**");

        addLoginedInterceptor.addPathPatterns("/login.html").addPathPatterns("/login");
    }
}
