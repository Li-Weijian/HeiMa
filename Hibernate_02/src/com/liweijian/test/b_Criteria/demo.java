package com.liweijian.test.b_Criteria;

import com.liweijian.domain.Customer;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description: Criteria批量查询  -- 适用于单表查询
 * @Date:Create in 23:21 2018/1/7 0007
 */
public class demo {

    @Test
    //基本查询
    public void fun1(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //================================================================

        //1.创建Criteria查询对象
        Criteria criteria = session.createCriteria(Customer.class);

        List<Customer> list = criteria.list();  //返回list结果集
        //Customer customer = (Customer) criteria.uniqueResult(); //返回单一结果集

        System.out.println(list);
        //================================================================

        tx.commit();
        session.close();

    }

    @Test
    //条件查询 -- add添加查询参数
    // > 				gt
    // >=				ge
    // <				lt
    // <=				le
    // ==				eq
    // !=				ne
    // in				in
    // between and		between
    // like 			like
    // is not null 		isNotNull
    // is null			isNull
    // or				or
    // and				and
    public void fun2(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //================================================================
        //2.创建Criteria查询对象
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("cust_id",5L));
        Customer customer = (Customer) criteria.uniqueResult(); //返回单一结果集

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
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.setFirstResult(0);   //从0页开始      limit 0,1
        criteria.setMaxResults(2);    //查两条数据
        List<Customer> list = criteria.list();  //返回list结果集
        //Customer customer = (Customer) query.uniqueResult(); //返回单一结果集

        System.out.println(list);
        //================================================================

        tx.commit();
        session.close();

    }

    @Test
    //查询总条数
    public void fun5(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //================================================================
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.setProjection(Projections.rowCount());
        Long row = (Long) criteria.uniqueResult();
        System.out.println(row);
        //================================================================

        tx.commit();
        session.close();

    }

}
