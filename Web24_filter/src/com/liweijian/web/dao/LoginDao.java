package com.liweijian.web.dao;

import com.liweijian.domain.User;
import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 17:46 2017/12/15 0015
 */
public class LoginDao {
    public User login(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from user where username=? and password=?";
        User user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
        return user;

    }
}
