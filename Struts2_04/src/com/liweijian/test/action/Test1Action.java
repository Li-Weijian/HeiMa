package com.liweijian.test.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:26 2018/1/16 0016
 */
public class Test1Action extends ActionSupport {


    public String add() throws Exception {
        System.out.println("add running..");
        return SUCCESS;
    }
    public String delete() throws Exception {
        System.out.println("delete running..");
        return SUCCESS;
    }
    public String update() throws Exception {
        System.out.println("update running..");
        return SUCCESS;
    }
    public String save() throws Exception {
        System.out.println("save running..");
        return SUCCESS;
    }
}
