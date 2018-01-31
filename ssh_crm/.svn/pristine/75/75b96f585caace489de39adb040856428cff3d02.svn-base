package com.liweijian.service.impl;

import com.liweijian.dao.UserDao;
import com.liweijian.domain.User;
import com.liweijian.service.UserService;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:48 2018/1/23 0023
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    //登录
    public User getUserByCodePassword(User user) {

        //1.调用dao去查询用户
        User u = userDao.getByUserCode(user.getUser_code());

        //2.判断用户名是否正确
        if (u == null) {
            throw new RuntimeException("用户名不正确");
        }
        //3.判断密码是否正确
        if (!u.getUser_password().equals(user.getUser_password())){
            throw new RuntimeException("密码不正确");
        }

        return u;
    }

    @Override
    //注册
    public void save(User user) {
        User existUser = userDao.getByUserCode(user.getUser_code());
        if (existUser != null){
            //用户名已存在
            throw new RuntimeException("登录名已存在");
        }else {
            userDao.save(user);
        }
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
