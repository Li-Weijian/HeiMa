package cn.liweijian.jdbc;

import java.sql.*;

public class JDBCUtils_V1 {

    //获取连接方法
    public static Connection getConnection(){

        Connection conn = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "qq352642663");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }

    //关闭连接方法
    public  static void release(Connection conn, PreparedStatement pstat, ResultSet rs){

        if (conn != null) try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (pstat != null) try {
            pstat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rs != null) try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
