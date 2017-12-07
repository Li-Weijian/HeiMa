package com.liweijian.transaction.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MyDataSourceUtils {

	//获得连接 -- 从c3p0中获取
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	//创建ThreadLocal对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


	//开启事务
	public static void startTransaction() throws SQLException {

		//获取当前线程的Connection
		Connection conn = getCurrentConnection();
		conn.setAutoCommit(false);
	}

	//获得新Connection
	public static Connection getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		return conn;
	}

	//获得当前线程的Connection
	public static Connection getCurrentConnection() throws SQLException {
		Connection conn = threadLocal.get();

		//如果当前线程没有连接，则创建一个并放入ThreadLocal中
		if (conn == null){
			conn = getConnection();
			threadLocal.set(conn);
		}

		return conn;
	}


	//回滚事务
	public static void rollback() throws SQLException {
		Connection conn = getCurrentConnection();
		conn.rollback();
	}

	//提交事务
	public static void commit() throws SQLException {
		Connection conn = getCurrentConnection();
		conn.commit();
	}
}
