package com.liweijian.dao;

import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:50 2017/12/9 0009
 */
public class AdminDelProductByCheckedDao {

    public void delProductByChecked(String[] uid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "delete from product where pid=?";

        for (int i = 0; i < uid.length; i++){
            queryRunner.update(sql,uid[i]);
        }
    }
}
