package com.liweijian.transaction.DBUtils;

import com.liweijian.transaction.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: DBUtilsDemo 开启事务的方式
 * @Date:Create in 17:13 2017/12/7 0007
 */
public class DBUtilsDemo {

    public static void main(String[] args) {

        //此处不提供连接池,因为事务使用的必须是同一个connection，使用连接池将导致connection不明
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = null;

        try {
            conn.setAutoCommit(false);
            conn = DataSourceUtils.getConnection();
            int update = queryRunner.update(conn, "update account set money=10000 where name='Tom'");

            /*
            * 此处还有一个漏洞：假如用户不存在更新失败时，是不会抛出异常，因此需要使用返回值进行判断
            * */
            if (update <= 0){
                new RuntimeException();
            }

            //提交
            conn.commit();
        } catch (SQLException e) {
            try {
                //回滚操作
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }


    }

}
