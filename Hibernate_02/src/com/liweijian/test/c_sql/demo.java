package com.liweijian.test.c_sql;

import com.liweijian.domain.Customer;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description: 原生sql查询  -- 适用于复杂的业务查询
 * @Date:Create in 23:21 2018/1/7 0007
 */
public class demo {

    @Test
    //基本查询
    public void fun1(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //================================================================

        //1.书写sql语句
        String sql = "select * from cst_customer";

        //2.创建sql查询对象
        SQLQuery query = session.createSQLQuery(sql);


        //3.1 获得结果集
        List<Object[]> list = query.list();  //返回list结果集 -- 因为是开发人员指定的sql语句，程序不知道我们查询的对象是什么，因此返回一个Object数组
        System.out.println(list);

        //3.2 获得对象结果集
        query.addEntity(Customer.class);  // 指定对象
        List<Customer> list_cst = query.list();
        System.out.println(list_cst);

        //================================================================

        tx.commit();
        session.close();

    }

    @Test
    //条件查询
    public void fun2(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //================================================================
        String sql = "select * from cst_customer where cust_id = ?";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter(0,5L);

        //将结果集指定到具体对象中
        query.addEntity(Customer.class);
        Customer customer = (Customer) query.uniqueResult();

        System.out.println(customer);
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
        String sql = "select * from cst_customer limit ?,?";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter(0,0);  //第一个参数为占位符的位置，第二个参数为占位符的值
        query.setParameter(1,2);

        //将结果集指定到具体对象中
        query.addEntity(Customer.class);
        List<Customer> list = query.list();
        System.out.println(list);
        //================================================================

        tx.commit();
        session.close();

    }
}
