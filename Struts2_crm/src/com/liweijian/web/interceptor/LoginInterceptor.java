package com.liweijian.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:19 2018/1/16 0016
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        Map<String, Object> session = ActionContext.getContext().getSession();
        Object user = session.get("user");
        if (user == null){
            //如果为空，则跳转到登录
            return "toLogin";
        }else {
           return actionInvocation.invoke();
        }
    }
}
