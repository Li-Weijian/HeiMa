package com.liweijian.test.a_HQL;

import com.liweijian.domain.Customer;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description: HQL批量查询  -- 适用于多表查询但是不复杂的情况下
 * @Date:Create in 23:21 2018/1/7 0007
 */
public class demo {

    @Test
    //基本查询
    public void fun1(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //================================================================
        //1.书写HQL语句
        //String hql = "from com.liweijian.domian.Customer";
        String hql = "from Customer";    //查询所有的Customer对象

        //2.创建HQL查询对象
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();  //返回list结果集
        //Customer customer = (Customer) query.uniqueResult(); //返回单一结果集

        System.out.println(list);
        //================================================================

        tx.commit();
        session.close();

    }

    @Test
    //条件查询  --  ? 占位符
    public void fun2(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //================================================================
        //1.书写HQL语句
        //String hql = "from com.liweijian.domian.Customer";
        String hql = "from Customer where cust_id = ?";    //查询所有的Customer对象

        //2.创建HQL查询对象
        Query query = session.createQuery(hql);
        query.setParameter(0,6L);        //设置占位符参数 -- 从0开始
        List<Customer> list = query.list();  //返回list结果集
        //Customer customer = (Customer) query.uniqueResult(); //返回单一结果集

        System.out.println(list);
        //================================================================

        tx.commit();
        session.close();

    }

    @Test
    //条件查询  --  : 命名占位符
    public void fun3(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //================================================================
        //1.书写HQL语句
        //String hql = "from com.liweijian.domian.Customer";
        String hql = "from Customer where cust_id = :cust_id";    //查询所有的Customer对象

        //2.创建HQL查询对象
        Query query = session.createQuery(hql);
        query.setParameter("cust_id",7L);        //设置占位符参数
        List<Customer> list = query.list();  //返回list结果集
        //Customer customer = (Customer) query.uniqueResult(); //返回单一结果集

        System.out.println(list);
        //================================================================

        tx.commit();
        session.close();

    }

    @Test
    //分页查询
    public void fun4(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //================================================================
        //1.书写HQL语句
        //String hql = "from com.liweijian.domian.Customer";
        String hql = "from Customer";    //查询所有的Customer对象

        //2.创建HQL查询对象
        Query query = session.createQuery(hql);
        query.setFirstResult(0);   //从0页开始      limit 0,1
        query.setMaxResults(2);    //查两条数据
        List<Customer> list = query.list();  //返回list结果集
        //Customer customer = (Customer) query.uniqueResult(); //返回单一结果集

        System.out.println(list);
        //================================================================

        tx.commit();
        session.close();

    }


}
