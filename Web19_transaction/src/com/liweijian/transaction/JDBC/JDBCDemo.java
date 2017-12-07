package com.liweijian.transaction.JDBC;


import java.sql.*;

/**
 * @Author:Liweijian
 * @Description: JDBC开始事务示例代码 -- 只需要设置为不自动提交且完成操作后提交即可
 * @Date:Create in 17:00 2017/12/7 0007
 */
public class JDBCDemo {

    public static void  main(String[] args){

        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得连接
            conn = DriverManager.getConnection("jdbc:mysql:///web19", "root", "qq352642663");

            //手动开启事务
            conn.setAutoCommit(false);

            //3.获得操作平台
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE ACCOUNT SET MONEY = 5000 WHERE NAME='Tom'");

            //提交事务
            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();    //回滚操作
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }


    }

}
