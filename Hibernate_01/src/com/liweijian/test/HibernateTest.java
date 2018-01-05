package com.liweijian.test;

import com.liweijian.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


/**
 * @Author:Liweijian
 * @Description: Hibernate测试类
 * @Date:Create in 22:58 2018/1/5 0005
 */
public class HibernateTest {


    @Test
    public void test1(){

        //1.加载配置文件
        Configuration cfg = new Configuration().configure();

        //2.创建一个SessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        //3.创建一个session对象
        Session session = sessionFactory.openSession();

        //4.开启事务
        Transaction tx = session.beginTransaction();

        //5.执行相关操作
        Customer customer = new Customer();
        customer.setCust_name("百度");
        session.save(customer);

        //6.提交
        tx.commit();

        //7.释放资源
        session.close();
    }

}
