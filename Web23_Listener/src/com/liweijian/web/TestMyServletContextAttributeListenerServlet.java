package com.liweijian.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: 测试ServletContextAttributeListener
 * @Date:Create in 22:58 2017/12/13 0013
 */
@WebServlet(name = "TestMyServletContextAttributeListenerServlet")
public class TestMyServletContextAttributeListenerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        context.setAttribute("name","zhangsan");    //添加
        context.setAttribute("name","lisi");        //修改
        context.removeAttribute("name");               //删除
    }
}
