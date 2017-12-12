package com.liweijian.service;

import com.liweijian.dao.AdminDelProductDao;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: service层，处理业务代码
 * @Date:Create in 21:01 2017/12/9 0009
 */
public class AdminDelProductService {


    public void delProduct(String pid) throws SQLException {

        AdminDelProductDao dao = new AdminDelProductDao();
        dao.delProduct(pid);

    }
}
