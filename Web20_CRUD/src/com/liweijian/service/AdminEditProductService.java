package com.liweijian.service;

import com.liweijian.dao.AdminEditProductDao;
import com.liweijian.domain.Product;
import com.liweijian.web.AdminEditProductServlet;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 19:29 2017/12/10 0010
 */
public class AdminEditProductService {
    public void updateProductById(Product product) throws SQLException {

        AdminEditProductDao dao = new AdminEditProductDao();
        dao.updateProductById(product);
    }
}
