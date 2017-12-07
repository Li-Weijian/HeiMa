package com.liweijian.dao;

import com.liweijian.domain.Product;
import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description: dao层，负责与数据库交互
 * @Date:Create in 13:53 2017/12/6 0006
 */
public class ProductListDao {


    public List<Product> findAllProduct() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from product";
        List<Product> productList = queryRunner.query(sql,new BeanListHandler<Product>(Product.class));

        //将数据往上层返回
        return productList;

    }

}


