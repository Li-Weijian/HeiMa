package com.liweijian.test1;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @Author:Liweijian
 * @Description: 测试Spring中的JDBCTemplate
 * @Date:Create in 20:44 2018/1/22 0022
 */
public class Test1 {

    @Test
    public void fun() throws PropertyVetoException {

        //1.准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///t1");
        dataSource.setUser("root");
        dataSource.setPassword("qq352642663");

        //2.创建JDBC模版
        JdbcTemplate template = new JdbcTemplate(dataSource);

        //3.书写sql
        String sql = "insert into t_user values(null,'rose')";
        template.update(sql);
    }
}
