package com.liweijian.transfer.dao;

import com.liweijian.transaction.utils.MyDataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 18:22 2017/12/7 0007
 */
public class TransferDao {
    public void in(String in, double money) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = MyDataSourceUtils.getCurrentConnection();
        queryRunner.update(conn,"update account set money=money+? where name=?",money,in);
    }

    public void out(String out, double money) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = MyDataSourceUtils.getCurrentConnection();
        queryRunner.update(conn,"update account set money=money-? where name=?",money,out);
    }
}
