package com.liweijian.dao;

import com.liweijian.domain.Product;
import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:42 2017/12/11 0011
 */
public class ProductListDao {
    private Object totalCount;

    public List<Product> findAllProduct() throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from product";
        List<Product> productList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
        return productList;

    }

    public int getTotalCount() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select count(*) from product";
        Long totalCount = (Long)queryRunner.query(sql, new ScalarHandler());  /*语句获取返回的类型为long*/
        return totalCount.intValue();
    }

    public List<Product> findProductListFroPageBean(int index, int currentCount) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product limit ?,?";   //第一个参数是从哪里开始显示 第二个参数是显示多少个

        List<Product> productList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), index, currentCount);
        return productList;
    }
}
