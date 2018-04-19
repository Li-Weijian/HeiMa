package com.liweijian.controller.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 * */
public class CustomerHandlerException implements HandlerExceptionResolver {

    private String msg;

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        if (e instanceof MesException){
            MesException mesEx = (MesException) e;
            //自定义已知异常。
            msg = mesEx.getMes();
        }else {
            //未知异常
            msg = e.getMessage();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
