package com.liweijian.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @Author:Liweijian
 * @Description: 拦截器创建方式：实现MethodFilterInterceptor
 * @Date:Create in 21:20 2018/1/16 0016
 */
public class MyInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("拦截器前处理");
        actionInvocation.invoke();      //放行
        System.out.println("拦截器后处理");

        //不放行，直接返回交给结果集处理
        return "success";
    }
}
