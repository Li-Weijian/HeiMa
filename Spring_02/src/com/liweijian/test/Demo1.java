package com.liweijian.test;

import com.liweijian.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 16:00 2018/1/20 0020
 */
public class Demo1 {

    @Test
    public void fun1(){

        //1.创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.根据容器获得对象
        User user = (User) ac.getBean("user");

        //3.操作对象
        System.out.println(user.toString());

    }



}
