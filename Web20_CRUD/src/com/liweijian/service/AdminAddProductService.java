package com.liweijian.service;

import com.liweijian.dao.AdminAddProductDao;
import com.liweijian.domain.Product;
import com.liweijian.web.AdminAddProductServlet;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 10:45 2017/12/9 0009
 */
public class AdminAddProductService {

    public void addProduct(Product product) throws SQLException {

        AdminAddProductDao dao = new AdminAddProductDao();
        dao.addProduct(product);
    }
}
