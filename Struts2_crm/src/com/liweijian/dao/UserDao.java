package com.liweijian.dao;

import com.liweijian.domain.User;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:45 2018/1/16 0016
 */
public interface UserDao {
    //根据用户名查询用户
    User findUserByUserCode(String user_code);
}
