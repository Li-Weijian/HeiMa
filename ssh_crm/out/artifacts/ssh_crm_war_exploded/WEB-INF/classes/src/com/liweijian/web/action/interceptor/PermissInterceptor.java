package com.liweijian.web.action.interceptor;

import com.liweijian.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:20 2018/1/31 0031
 */
public class PermissInterceptor extends MethodFilterInterceptor {
    @Override
    //不校验登录和注册
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //1.获得session
        User user = (User) ActionContext.getContext().getSession().get("user");
        //2.如果session有用户标识，则放行，
        if (user != null){
            return actionInvocation.invoke();
        }else {
           //3.否则重定向到登录页面
            return "toLogin";
        }
    }
}
