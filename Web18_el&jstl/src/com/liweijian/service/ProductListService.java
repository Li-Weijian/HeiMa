package com.liweijian.service;

import com.liweijian.dao.ProductListDao;
import com.liweijian.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description: service 层，处理业务代码
 * @Date:Create in 13:51 2017/12/6 0006
 */
public class ProductListService {


    //将数据传递到dao层进行数据查询
    public List<Product> findAllProduct() throws SQLException {
        ProductListDao dao = new ProductListDao();
        List<Product> productList = dao.findAllProduct();

        return productList;


    }
}
