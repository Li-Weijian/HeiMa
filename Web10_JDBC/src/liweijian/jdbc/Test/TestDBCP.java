package liweijian.jdbc.Test;

import liweijian.jdbc.Util.DBCPUtil;
import liweijian.jdbc.Util.JDBCUtils_V3;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: DBCP测试类
 * @Date:Create in 12:54 2017/10/23 0023
 */
public class TestDBCP {
    //1.创建连接对象和PreparedStatement对象
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    @Test
     public void UpdateUserById(){

         try {
             //2.获取连接
             connection = DBCPUtil.getConnection();
             //3.创建数据库语句并传入
             String sql = "update user set upassword=? where uid=?";
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1,"柳岩");
             preparedStatement.setInt(2,5);

             int row = preparedStatement.executeUpdate();
             if (row > 0){
                 System.out.println("更新成功");
             }else {
                 System.out.println("更新失败");
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
}

