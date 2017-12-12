package com.liweijian.service;

import com.liweijian.dao.AdminAddProductUIDao;
import com.liweijian.domain.Category;
import com.liweijian.web.AdminAddProductUIServlet;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:54 2017/12/8 0008
 */
public class AdminAddProductUIService {


    public List<Category> findAllCategory() throws SQLException {
        AdminAddProductUIDao dao = new AdminAddProductUIDao();
        List<Category> categoryList = dao.findAllCategory();
        return categoryList;
    }
}
