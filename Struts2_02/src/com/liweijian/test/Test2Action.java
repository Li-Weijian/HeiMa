package com.liweijian.test;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Author:Liweijian
 * @Description: 1.测试结果处理方式
 * @Date:Create in 21:41 2018/1/12 0012
 */
public class Test2Action extends ActionSupport {


    @Override
    public String execute() throws Exception {

        System.out.println("经过Test2Action!");

        return SUCCESS;
    }
}
