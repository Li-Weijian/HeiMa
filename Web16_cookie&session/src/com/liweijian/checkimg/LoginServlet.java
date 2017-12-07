package com.liweijian.checkimg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: 验证码校验
 * @Date:Create in 17:22 2017/11/24 0024
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //1.获取验证码单词
        String checkcode_session = request.getParameter("checkCode");

        //2.获取用户提交的验证码
        String checkCode_client = (String) request.getSession().getAttribute("checkcode_session");

        System.out.println("session:" + checkcode_session);
        System.out.println("checkCode:" + checkCode_client);

        //3.校验验证码
        if (!checkCode_client.equals(checkcode_session)){
            request.setAttribute("loginInfo","输入的验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        //4.对用户登录信息进行校验
        //....

    }
}
