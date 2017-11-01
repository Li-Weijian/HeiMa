package liweijian.jdbc.Test;

import liweijian.jdbc.Util.JDBCUtils_V3;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: 测试自定义连接池
 * @Date:Create in 22:10 2017/10/20 0020
 */

public class testMyDataSource {

    //增强了close方法
    @Test
    public void testAddUser1() {

        Connection conn = null;
        PreparedStatement pstam = null;
        MyDataSource1 mds = new MyDataSource1();
        try {
            //1.从连接池中获取连接
            conn = mds.getConnection();
            //2.创建数据库语句
            String sql = "INSERT INTO USER VALUES (NULL,?,?)";
            //3.获取PreparedStatement并设置参数
            pstam = conn.prepareStatement(sql);
            pstam.setString(1, "吕布1");
            pstam.setString(2, "貂蝉1");

            int col = pstam.executeUpdate();
            //4.返回结果
            if (col != 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放连接
            //此处release调用的close是MyConnection中增强的close方法
          JDBCUtils_V3.release(conn,pstam,null);
        }
    }


    //未增强close方法
    @Test
    public void testAddUser(){

        Connection conn = null;
        PreparedStatement pstam = null;
        MyDataSource mds = new MyDataSource();
        try {
            //1.从连接池中获取连接
            conn = mds.getConnection();
            //2.创建数据库语句
            String sql = "INSERT INTO USER VALUES (NULL,?,?)";
            //3.获取PreparedStatement并设置参数
            pstam = conn.prepareStatement(sql);
            pstam.setString(1,"吕布");
            pstam.setString(2,"貂蝉");

            int col = pstam.executeUpdate();
            //4.返回结果
            if (col != 0){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.释放连接
            mds.backConnection(conn);
        }


    }
}
