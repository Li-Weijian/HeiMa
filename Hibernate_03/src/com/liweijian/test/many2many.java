package com.liweijian.test;

import com.liweijian.domain.Role;
import com.liweijian.domain.User;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @Author:Liweijian
 * @Description: 多对多关系的测试
 * @Date:Create in 0:11 2018/1/9 0009
 */
public class many2many {

    @Test
    public void fun1(){

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        //======================================================
        User user1 = new User();
        User user2 = new User();
        user1.setUser_name("张三");
        user2.setUser_name("王武");

        Role role1 = new Role();
        Role role2 = new Role();
        role1.setRole_name("ceo");
        role2.setRole_name("cto");

        //user维护关系
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role1);
        user2.getRoles().add(role2);

        //role维护关系
        role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role2.getUsers().add(user1);
        role2.getUsers().add(user2);

        session.save(user1);
        session.save(user2);
        session.save(role1);
        session.save(role2);

        //======================================================

        tx.commit();
        session.close();



    }
}
