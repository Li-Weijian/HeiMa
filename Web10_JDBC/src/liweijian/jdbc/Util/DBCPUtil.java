//package liweijian.jdbc.Util;
//
//import org.apache.commons.dbcp.BasicDataSourceFactory;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Properties;
//
///**
// * @Author:Liweijian
// * @Description: DBCP的工具类
// * @Date:Create in 12:08 2017/10/23 0023
// */
//public class DBCPUtil {
//
//    private static DataSource dataSource = null;
//
//    //1.将jar包导入
//    //2.书写静态代码块以读取properties文件
//    static {
//        try {
//            InputStream is = DBCPUtil.class.getClassLoader().getResourceAsStream("db.properties");  //获取类加载器以得到流
//
//            Properties properties = new Properties();   //创建properties对象，加载读取的流
//            properties.load(is);
//
//            //创建数据源
//            dataSource = BasicDataSourceFactory.createDataSource(properties);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public static Connection getConnection() {
//        try {
//            return dataSource.getConnection();
//        } catch (SQLException e) {
//            System.out.println("出错啦 -- ");
//            throw new RuntimeException(e);
//        }
//    }
//
//}


package liweijian.jdbc.Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtil {
    private static DataSource dataSource;
    static{
        try {
            //1.加载找properties文件输入流
            InputStream is = DBCPUtil.class.getClassLoader().getResourceAsStream("db.properties");
            //2.加载输入流
            Properties props = new Properties();
            props.load(is);
            //3.创建数据源
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
