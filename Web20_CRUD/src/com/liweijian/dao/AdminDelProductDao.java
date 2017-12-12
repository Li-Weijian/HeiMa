package com.liweijian.dao;

import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:02 2017/12/9 0009
 */
public class AdminDelProductDao {


    public void delProduct(String pid) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "delete from product where pid=?";
        queryRunner.update(sql, pid);

    }
}
