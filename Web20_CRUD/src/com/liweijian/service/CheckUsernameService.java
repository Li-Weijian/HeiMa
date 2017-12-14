package com.liweijian.service;

import com.liweijian.dao.CheckUsernameDao;
import com.liweijian.web.CheckUsernameServlet;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:35 2017/12/12 0012
 */
public class CheckUsernameService {
    public boolean checkUsername(String username) throws SQLException {
        CheckUsernameDao dao = new CheckUsernameDao();
        Long isExist = dao.checkUsername(username);

        return isExist>0?true:false;
    }
}
