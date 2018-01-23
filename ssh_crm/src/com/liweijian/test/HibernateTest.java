package com.liweijian.test;

import com.liweijian.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @Author:Liweijian
 * @Description: 测试Hibernate框架
 * @Date:Create in 23:58 2018/1/23 0023
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

    //注入
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    @Test
    //测试Hibernate框架
    //测试Hibernate与Spring的整合
    //测试c3p0连接池的整合
    public void fun1(){

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        User user = new User();
        user.setUser_code("tom");
        user.setUser_name("汤姆");
        user.setUser_password("1234");

        session.save(user);

        tx.commit();
        session.close();
    }




}
