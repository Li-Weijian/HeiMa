package com.liweijian.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * @Author:Liweijian
 * @Description: 钝化与活化监听器
 * @Date:Create in 15:55 2017/12/14 0014
 */
public class Customer implements HttpSessionActivationListener, Serializable{
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

    //钝化 -- 存储到硬盘
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("session被钝化了..");
    }

    //活化 -- 读取到内存
    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("session被活化了..");
    }
}
