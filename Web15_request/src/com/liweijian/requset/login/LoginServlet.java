package com.liweijian.requset.login;

import com.liweijian.requset.Register.User;
import com.liweijian.requset.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: 登录
 * @Date:Create in 23:45 2017/11/19 0019
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取表单信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginInfo = null;

        //2.校验表单信息
        try {
             loginInfo = login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3.判断用户信息
        if (loginInfo!= null){
            //用户名和密码正确，跳转到首页
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //存储登录信息并转发到jsp中
            request.setAttribute("loginInfo","用户名或者密码不正确");
            request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request,response);
        }


    }


    //校验用户信息
    public User login(String username,String password) throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from user where username=? and password=?";

        User user = runner.query(sql, new BeanHandler<User>(User.class), username, password);

        return user;

    }


}
