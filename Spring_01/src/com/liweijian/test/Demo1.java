package com.liweijian.test;

import com.liweijian.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:Liweijian
 * @Description: 1.测试Spring
 * @Date:Create in 21:23 2018/1/18 0018
 */
public class Demo1 {


    @Test
    public void fun1() {
        //1.创建容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.根据容器获取对象
        User user = (User) ac.getBean("user");
        //3.操作对象
        System.out.println(user.toString());
        //4.关闭容器，触发销毁方法
        ac.close();
    }


}
