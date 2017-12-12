package com.liweijian.service;

import com.liweijian.dao.AdminDelProductByCheckedDao;
import com.liweijian.web.AdminDelProductByCheckedServlet;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:49 2017/12/9 0009
 */
public class AdminDelProductByCheckedService {

    public void delProductByChecked(String[] uid) throws SQLException {
        AdminDelProductByCheckedDao dao = new AdminDelProductByCheckedDao();
        dao.delProductByChecked(uid);
    }
}
