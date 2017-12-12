package com.liweijian.service;

import com.liweijian.dao.AdminProductListDao;
import com.liweijian.domain.Product;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:19 2017/12/8 0008
 */
public class AdminProductListService {

    //查找所有商品
    public List<Product> findAllProduct() {
        AdminProductListDao dao = new AdminProductListDao();
        List<Product> productList = dao.findAllProduct();

        return productList;
    }
}
