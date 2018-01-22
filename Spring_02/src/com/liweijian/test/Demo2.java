package com.liweijian.test;

import com.liweijian.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 16:57 2018/1/20 0020
 */
public class Demo2 {


    @Test
    public void fun1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.add();
    }

}
