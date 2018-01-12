package com.liweijian.test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * @Author:Liweijian
 * @Description: 1.测试结果处理方式
 *               2.测试获得三大域对象并存储值
 * @Date:Create in 21:41 2018/1/12 0012
 */
public class TestAction extends ActionSupport {


    @Override
    public String execute() throws Exception {

        //在Struts2中，要获得session域、application域推荐通过ActionContext对象获得
        //其中，不推荐在Struts2中获得request，可以使用ActionContext代替

        //获得ActionContext域  -- 代替request域
        ActionContext.getContext().put("name","actionContext");

        //获得session域
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("name","session");

        //获得application域
        Map<String, Object> application = ActionContext.getContext().getApplication();
        application.put("name","application");


//        System.out.println("经过TestAction!");

        return SUCCESS;
    }
}
