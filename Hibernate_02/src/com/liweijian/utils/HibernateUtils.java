package com.liweijian.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:35 2018/1/6 0006
 */
public class HibernateUtils {
    /* 因为必须保证web工程中只能有一个SessionFactory对象
    *  因此我们考虑使用静态代码块来进行初始化
    * */
    static SessionFactory sessionFactory = null;
    static {
        //新建配置加载类并加载配置
        Configuration conf = new Configuration().configure();
        //新建工厂类
         sessionFactory = conf.buildSessionFactory();
    }

    //打开session
    public static Session openSession() {
        //开启Session
        Session session = sessionFactory.openSession();
        return session;
    }

    //获得当前线程绑定的Session
    public static Session getCurrentSession() {
        //开启Session
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}


