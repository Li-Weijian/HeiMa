package com.liweijian.dao;

import com.liweijian.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserdaoImpl extends SqlSessionDaoSupport implements Userdao {

    @Override
    public User selectUserById(String id) {
        User user = getSqlSession().selectOne("com.liweijian.dao.Userdao.selectUserById",id);
        return user;
    }
}
