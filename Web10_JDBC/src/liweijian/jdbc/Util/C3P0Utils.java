package liweijian.jdbc.Util;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: c3p0工具类
 * @Date:Create in 22:55 2017/10/22 0022
 */
public class C3P0Utils {

    //1.new一个类，连接c3p0
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //private ComboPooledDataSource dataSource = new ComboPooledDataSource("liweijian");

    //2.获取数据源
    public static DataSource getDataSource(){
        return dataSource;
    }

    //3.返回连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
