package com.liweijian.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @Author:Liweijian
 * @Description: ServletContextAttribute的监听器
 * @Date:Create in 22:51 2017/12/13 0013
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener
{

    /*
    *  执行过程 -- 个人理解
    *  1. 启动Tomcat容器
    *  2. 访问Servlet时，通过对Attribute的操作
    *  3. ServletContextAttribute的监听器监听到具体操作
    *  4. 执行相关方法
    *
    *  因此，一定不能忘记在web.xml中注册监听器
    * */

    //属性添加监听方法
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(servletContextAttributeEvent.getName());     //获得添加的name
        System.out.println(servletContextAttributeEvent.getValue());    //获得添加的value

    }

    //属性删除监听方法
    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(servletContextAttributeEvent.getName());    //获得删除的name
        System.out.println(servletContextAttributeEvent.getValue());    //获得删除的value

    }

    //属性修改监听方法
    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(servletContextAttributeEvent.getName());    //获得修改前的的name
        System.out.println(servletContextAttributeEvent.getValue());    //获得修改前的value

    }
}
