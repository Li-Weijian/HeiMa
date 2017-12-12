package com.liweijian.dao;

import com.liweijian.domain.Product;
import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:21 2017/12/8 0008
 */
public class AdminProductListDao {

    public List<Product> findAllProduct() {

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        List<Product> productList = null;

        String sql = "select * from product";
        try {
            productList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
}
