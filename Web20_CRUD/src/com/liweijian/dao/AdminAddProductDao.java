package com.liweijian.dao;

import com.liweijian.domain.Product;
import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 11:04 2017/12/9 0009
 */
public class AdminAddProductDao {

    public void addProduct(Product product) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
        queryRunner.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),
                product.getPimage(),product.getPdate(),product.isIs_hot(),product.getPdesc(),product.getPflag(),product.getCid());

    }
}
