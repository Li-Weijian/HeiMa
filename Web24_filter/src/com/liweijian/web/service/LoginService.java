package com.liweijian.web.service;

import com.liweijian.domain.User;
import com.liweijian.web.dao.LoginDao;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 17:46 2017/12/15 0015
 */
public class LoginService {


    public User login(String username, String password) throws SQLException {
        LoginDao dao = new LoginDao();
        return dao.login(username,password);
    }
}
