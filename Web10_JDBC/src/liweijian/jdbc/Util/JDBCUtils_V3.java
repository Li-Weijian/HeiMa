package liweijian.jdbc.Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils_V3 {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;


    static {
        //1.获得类加载器
        ClassLoader loader = JDBCUtils_V3.class.getClassLoader();
        //2.获得输入流
        InputStream rs = loader.getResourceAsStream("db.properties");
        //3.创建properties对象
        Properties props = new Properties();
        //4.加载流
        try {
            props.load(rs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //5.获取properties数据
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        password = props.getProperty("password");



     /*   //获取properties键值对的方法
        ResourceBundle bundle = ResourceBundle.getBundle("db");     //注意，不能加后缀
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        user = bundle.getString("user");
        password = bundle.getString("password");
       */
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
