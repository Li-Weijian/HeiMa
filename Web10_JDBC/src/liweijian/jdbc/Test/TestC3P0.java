package liweijian.jdbc.Test;

import liweijian.jdbc.Util.C3P0Utils;
import liweijian.jdbc.Util.JDBCUtils_V3;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: c3p0测试类
 * @Date:Create in 22:52 2017/10/22 0022
 */
public class TestC3P0 {

    @Test
    public void testAddUser1() {

        Connection conn = null;
        PreparedStatement pstam = null;
        try {

            //1.从池子中获取连接
            conn = C3P0Utils.getConnection();
            String sql = "INSERT INTO USER VALUES (NULL,?,?)";
            //3.获取PreparedStatement并设置参数
            pstam = conn.prepareStatement(sql);
            pstam.setString(1, "吕布2");
            pstam.setString(2, "貂蝉2");

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
}
