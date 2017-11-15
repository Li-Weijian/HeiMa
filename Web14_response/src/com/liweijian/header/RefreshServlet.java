package com.liweijian.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: 定时刷新（重定向）
 * @Date:Create in 21:10 2017/11/15 0015
 */
@WebServlet(name = "RefreshServlet")
public class RefreshServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置刷新头，5秒重定向到指定地址
        response.setHeader("refresh","5;url=http://www.baidu.com");
    }
}
