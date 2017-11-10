package com.liweijian.login;

import com.liweijian.domain.User;
import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * @Author:Liweijian
 * @Description: 模拟用户登录
 * @Date:Create in 20:19 2017/11/10 0010
 */

    //1.创建login.html页面
    //2.创建servlet
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws   ServletException, IOException {

        //1.获得用户的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user;

        //2.从数据库判断用户名和密码
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from User where username = ? and password = ?";
        try {
            user = queryRunner.query(sql, new BeanHandler<User>(User.class), username, password);

            //3.输出验证结果
            if (user!= null){
                response.getWriter().write(user.toString());
            }else {
                response.getWriter().write("sorry, your username or password is wrong!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
