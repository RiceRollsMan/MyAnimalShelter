package com.ft.animalshelter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        //登录有Session
        Object loginUser = request.getSession().getAttribute("user");
        if(loginUser==null){
            //未登录，给一个消息并且返回到前台页面
            System.out.println("没权限登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
         return true;
    }
}
