package com.liweijian.test2;

import com.liweijian.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:35 2018/1/22 0022
 */
public class Test2 {

    @Test
    public void fun1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        User user = new User();
        user.setName("java");
        userDao.save(user);
    }

    @Test
    public void fun2(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        User user = new User();
        user.setId(2);
        user.setName("c++");
        userDao.update(user);
    }

    @Test
    public void fun3(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        userDao.delete(2);
    }

    @Test
    public void fun4(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        User user = userDao.getById(3);
        System.out.println(user.toString());
    }

    @Test
    public void fun5(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        int byTotalCount = userDao.getByTotalCount();

        System.out.println(byTotalCount);
    }

    @Test
    public void fun6(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        List<User> all = userDao.getAll();

        System.out.println(all);

    }
}
