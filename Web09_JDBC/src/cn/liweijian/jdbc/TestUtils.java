package cn.liweijian.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUtils {


    //testDelete()方法调用了JDBCUtils_V3的连接方法
    //该方法使用的是properties对象获取键值对
    @Test
    public void testDelete(){
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = JDBCUtils_V3.getConnection();
            String sql = "delete from user where uid = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,4);
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                System.out.println("删除数据成功！");
            }else {
                System.out.println("删除数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils_V3.release(conn,preparedStatement,null);
        }


    }


    //testAdd方法调用了JDBCUtils_V2中的连接方法，该方法运用properties进行连接
    @Test
    public void testAdd(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils_V2.getConnection();
            String sql = "INSERT INTO USER VALUES (NULL ,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"lisi");
            preparedStatement.setString(2,"lisi");
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                System.out.println("插入数据成功！");
            }else {
                System.out.println("插入数据失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils_V2.release(connection,preparedStatement,null);
        }

    }


    @Test
    public void testFindUserById(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            //1.注册驱动，获取连接
             connection = JDBCUtils_V1.getConnection();
            //2.获取statement
            String sql = "select * from user where uid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,2);
            //3.操作数据
             rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils_V1.release(connection,preparedStatement,rs);
        }


    }



}
