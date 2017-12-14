package com.liweijian.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author:Liweijian
 * @Description: ServletContextListener监听类
 *              1.实现ServletContextListener接口
 *              2.在web.xml中注册监听器
 *              3.在监听类中的对应方法实现功能
 * @Date:Create in 18:24 2017/12/13 0013
 */
public class MyServletContextListener implements ServletContextListener{

    //context创建方法 -- 容器启动时
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        System.out.println("Context创建了...");
//        两个方法效果一样
//        ServletContext servletContext = servletContextEvent.getServletContext();
//        ServletContext source = (ServletContext)servletContextEvent.getSource();

        Timer timer = new Timer();
        /*
        *  TimerTask : 任务
        *  firsttime : 第一次执行的时间
        *  period ：间隔时间
        * */
        /*timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("开始计费");
            }
        },new Date(),1000);*/


        /*修改成银行的真实业务
        * 1. 十二点开始计息
        * 2. 每隔二十四个小时执行一次
        * */
        String currentTime = "2017-12-14 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date time = null;

        try {
            time = format.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("开始计费");
            }
        },time,60*1000*60*24);
    }

    //context销毁方法  -- 容器停止时
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context销毁了...");

    }
}
