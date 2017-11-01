package cn.liweijian.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtils_V2 {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;


    static {
        //获取properties键值对的方法
        ResourceBundle bundle = ResourceBundle.getBundle("db");     //注意，不能加后缀
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        user = bundle.getString("user");
        password = bundle.getString("password");

    }

    //获取连接方法
    public static Connection getConnection(){

        Connection conn = null;

        try {
            //1.注册驱动
            Class.forName(driver);
            //2.获取连接
            conn = DriverManager.getConnection(url,user,password);
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
