package com.liweijian.dao;

import com.liweijian.domain.Product;
import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 19:30 2017/12/10 0010
 */
public class AdminEditProductDao {
    public void updateProductById(Product product) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
        queryRunner.update(sql,product.getPname(),product.getMarket_price(),product.getShop_price(),
                product.getPimage(),product.getPdate(),product.isIs_hot(),product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
    }
}
