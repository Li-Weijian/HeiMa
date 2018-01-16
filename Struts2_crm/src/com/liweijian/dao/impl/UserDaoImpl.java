package com.liweijian.dao.impl;

import com.liweijian.dao.UserDao;
import com.liweijian.domain.User;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:46 2018/1/16 0016
 */
public class UserDaoImpl implements UserDao {


    @Override
    public User findUserByUserCode(String user_code) {
        Session session = HibernateUtils.getCurrentSession();
        String hql = "from User where user_code = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,user_code);
        User exitesUser = (User) query.uniqueResult();

        return exitesUser;
    }
}
