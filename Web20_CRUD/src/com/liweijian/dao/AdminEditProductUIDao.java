package com.liweijian.dao;

import com.liweijian.domain.Product;
import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.xml.crypto.Data;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 10:50 2017/12/10 0010
 */
public class AdminEditProductUIDao {
    public Product findProductById(String pid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from product where pid=?";
        Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class), pid);
        return product;
    }
}
