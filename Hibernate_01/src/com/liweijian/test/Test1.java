package com.liweijian.test;

import com.liweijian.domain.Customer;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @Author:Liweijian
 * @Description: Hibernate增删改查
 * @Date:Create in 22:21 2018/1/6 0006
 */
public class Test1 {

    @Test
    //添加操作
    public void fn1() {
        Session session = HibernateUtils.openSession();
        //开始事务
        Transaction tx = session.beginTransaction();

        //-------------------------------------------------
        Customer customer = new Customer();
        customer.setCust_name("谷歌");
        session.save(customer);
        //-------------------------------------------------

        tx.commit();
        //tx.rollback();   //回滚
        //释放资源
        session.close();
    }

    @Test
    //修改操作
    public void fn2() {
        Session session = HibernateUtils.openSession();
        //开始事务
        Transaction tx = session.beginTransaction();

        //-------------------------------------------------
        Customer customer = session.get(Customer.class, 4L);  //根据类和ID进行查询
        customer.setCust_name("百度");
        session.save(customer);
        //-------------------------------------------------

        tx.commit();
        //tx.rollback();   //回滚
        //释放资源
        session.close();
    }


    @Test
    //查询操作
    public void fn3() {
        Session session = HibernateUtils.openSession();
        //开始事务
        Transaction tx = session.beginTransaction();

        //-------------------------------------------------
        Customer customer = session.get(Customer.class, 4L);
        System.out.println(customer.toString());
        //-------------------------------------------------

        tx.commit();
        //tx.rollback();   //回滚
        //释放资源
        session.close();
    }

    @Test
    //删除操作
    public void fn4() {
        Session session = HibernateUtils.openSession();
        //开始事务
        Transaction tx = session.beginTransaction();

        //-------------------------------------------------
        Customer customer = session.get(Customer.class, 4L);
        session.delete(customer);
        //-------------------------------------------------

        tx.commit();
        //tx.rollback();   //回滚
        //释放资源
        session.close();
    }
}
