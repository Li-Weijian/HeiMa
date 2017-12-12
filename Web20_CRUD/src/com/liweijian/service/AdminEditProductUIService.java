package com.liweijian.service;

import com.liweijian.dao.AdminEditProductUIDao;
import com.liweijian.domain.Product;
import com.liweijian.web.AdminEditProductUIServlet;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 10:48 2017/12/10 0010
 */
public class AdminEditProductUIService {
    public Product findProductById(String pid) throws SQLException {

        AdminEditProductUIDao dao = new AdminEditProductUIDao();
        Product product = dao.findProductById(pid);

        return product;
    }
}
