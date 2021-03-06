package liweijian.jdbc.Test;

import liweijian.jdbc.Util.JDBCUtils_V3;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @Author:Liweijian
 * @Description:  自定义连接池
 * @Date:Create in 21:56 2017/10/20 0020
 */
public class MyDataSource implements DataSource {

    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    //类加载前就自动生成五个连接，称为连接池
    static {
        for (int i = 0; i < 5; i++) {
            Connection conn = JDBCUtils_V3.getConnection();
            pool.add(conn);
        }
    }

    //获取连接方法。
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = null;

        //如果连接池中没有连接，将创建5个连接
        if (pool.size() == 0){
            for (int i = 0; i < 5; i++) {
                conn = JDBCUtils_V3.getConnection();
                pool.add(conn);
            }
        }
        //从池子中取出一个连接。
        conn = pool.remove(0);
        return conn;
    }

    //释放连接，将连接返回连接池
    public static void backConnection(Connection conn){
        pool.add(conn);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
