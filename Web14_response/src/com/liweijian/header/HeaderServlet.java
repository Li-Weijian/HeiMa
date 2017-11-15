package com.liweijian.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author:Liweijian
 * @Description: 需要进入开发者模式查看
 * @Date:Create in 20:38 2017/11/15 0015
 */
@WebServlet(name = "HeaderServlet")
public class HeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();

        //添加响应头
        response.addHeader("name","zhangsan");
        response.addDateHeader("birthday",date.getTime());

    }
}
