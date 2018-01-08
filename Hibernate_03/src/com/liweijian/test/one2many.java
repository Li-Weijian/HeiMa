package com.liweijian.test;

import com.liweijian.domain.Customer;
import com.liweijian.domain.Linkman;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @Author:Liweijian
 * @Description: 测试一对多关系
 * @Date:Create in 23:42 2018/1/8 0008
 */
public class one2many {


    @Test
    public void fun1(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //=========================================================
        //1.新建一个Customer对象
        Customer customer = new Customer();

        //2.设置Customer属性
        customer.setCust_name("百度");

        //3.新建两个Linkman对象
        Linkman linkman1 = new Linkman();
        Linkman linkman2 = new Linkman();

        //4.设置Linkman属性
        linkman1.setLkm_name("王五");
        linkman2.setLkm_name("张三");

        //5.添加Linkman到Customer
        customer.getLinkmen().add(linkman1);
        customer.getLinkmen().add(linkman2);

        //6.添加Customer到Linkman
        linkman1.setCustomer(customer);
        linkman2.setCustomer(customer);

        //7.保存 -- 持久化
        session.save(customer);
        /*如果在Customer映射文件中配置了级联保存，则以下两行代码可写可不写*/
        session.save(linkman1);
        session.save(linkman2);

        //=========================================================

        tx.commit();
        session.close();
    }

}
