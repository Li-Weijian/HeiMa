package cn.liweijian.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * JDBC连接步骤、sql注入问题
 * 
 * @author Liweijian
 * @date 2017年10月17日
 */
public class TestJDBC {

	// 测试类
	@Test
	public void testLogin() {
		try {
			login("zs' or 'zs'='zs", "zs' or 'zs'='zs");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 因为使用statement会存在sql注入问题
	// 因此推荐使用PreparedStatement(预编译声明)
	public void login(String username, String password) throws SQLException, ClassNotFoundException {
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取connection
		Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root",
				"qq352642663");
		// 3.获取statement
		Statement statement = conn.createStatement();
		// 4.向数据库发送语句
		String sql = "select * from user where uname = '" + username + "' and upassword = '" + password + "'";
		ResultSet re = statement.executeQuery(sql);
		// 5.读取结果
		if (re.next()) {
			System.out.println("恭喜," + username + ",登录成功！");
		} else {
			System.out.println("帐号或密码不存在");
		}
		// 6.关闭资源
		if (re != null)
			re.close();
		if (statement != null)
			statement.close();
		if (conn != null)
			conn.close();
	}

	// 防止sql注入
	public void login2(String username, String password) throws ClassNotFoundException, SQLException {

		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "qq352642663");
		// 3.获取是statement
		String sql = "select * from user where uname =?  and upassword =? ";
		PreparedStatement pStatement = conn.prepareStatement(sql);
		// 4.设置值
		pStatement.setString(1, username);
		pStatement.setString(2, password);
		// 5.向数据库传递语句
		ResultSet re = pStatement.executeQuery();
		// 6.读取结果
		if (re.next()) {
			System.out.println("恭喜," + username + ",登录成功！");
		} else {
			System.out.println("帐号或密码不存在");
		}

		// 7.关闭资源
		if (re != null)
			re.close();
		if (pStatement != null)
			pStatement.close();
		if (conn != null)
			conn.close();
	}

}
