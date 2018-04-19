package com.liweijian.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor1 implements HandlerInterceptor {
    //方法前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("方法前 1");
        String requestURI = httpServletRequest.getRequestURI();

        //判断请求是否为登录
        if (!requestURI.contains("login")){
            String username = (String) httpServletRequest.getSession().getAttribute("username");
           if(username == null){
            //未登录，重定向
               httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.action");
               return false;
            }
        }
        return true;
    }

    //方法后
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("方法后 1");
    }

    //页面渲染后
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("页面渲染 1");
    }
}
