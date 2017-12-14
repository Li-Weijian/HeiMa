package com.liweijian.dao;

import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:38 2017/12/12 0012
 */
public class CheckUsernameDao {
    public Long checkUsername(String username) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select count(*) from user where username=?";
        Long query = (Long)queryRunner.query(sql, new ScalarHandler(), username);
        return query;
    }
}
