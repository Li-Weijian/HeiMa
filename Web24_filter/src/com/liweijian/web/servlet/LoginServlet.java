package com.liweijian.web.servlet;

import com.liweijian.domain.User;
import com.liweijian.web.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 17:40 2017/12/15 0015
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String autoLogin = request.getParameter("autoLogin");
        User user = null;


        LoginService service = new LoginService();
        try {
            user = service.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //登录成功
        if (user != null){
            //勾选了自动登录
            if (autoLogin != null){
                //创建cookie
                Cookie cookie_username = new Cookie("cookie_username",username );
                Cookie cookie_password = new Cookie("cookie_password", password);
                //设置持久化时间
                cookie_username.setMaxAge(60*60);
                cookie_password.setMaxAge(60*60);
                //设置携带路径
                cookie_username.setPath(request.getContextPath());
                cookie_password.setPath(request.getContextPath());
                //添加cookie
                response.addCookie(cookie_username);
                response.addCookie(cookie_password);
            }

            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath());
        }else {
            //登录失败
            request.setAttribute("loginInfo", "用户名或者密码错误");
            request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request,response);
        }
    }
}
