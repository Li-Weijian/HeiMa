package com.liweijian.service.impl;

import com.liweijian.dao.UserDao;
import com.liweijian.dao.impl.UserDaoImpl;
import com.liweijian.domain.User;
import com.liweijian.service.UserService;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:40 2018/1/16 0016
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public User login(User user) {

        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //1.调用dao查询用户
        User exitesUser = userDao.findUserByUserCode(user.getUser_code());
        tx.commit();

        if (exitesUser == null){
            //如果不存在，则抛出异常，提示用户名错误
            throw new RuntimeException("用户名不正确");
        }else {
            //如果存在，则校验密码
            //2.校验密码
            if (!exitesUser.getUser_password().equals(user.getUser_password())) {
                //如果不一致。则抛出异常，提示密码错误
                throw new RuntimeException("密码不正确");
            } else {
                //如果一致，则返回
                return exitesUser;
            }

        }
    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
