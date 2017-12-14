package com.liweijian.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @Author:Liweijian
 * @Description: 测试绑定监听器实体
 * @Date:Create in 15:42 2017/12/14 0014
 */
public class Peoper implements HttpSessionBindingListener{

    /*
    *  当实体类被绑定到session时，
    *  将调用对应方法，不需要在web.xml中配置
    * */

    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //绑定方法
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Peoper被绑定。。");
    }

    //解绑方法
    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Peoper被解绑。。");

    }
}
