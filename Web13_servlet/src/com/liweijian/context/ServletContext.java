package com.liweijian.context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: context测试类
 * @Date:Create in 23:26 2017/11/10 0010
 */
@WebServlet(name = "ServletContext")
public class ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获得context对象
        javax.servlet.ServletContext context = getServletContext();
        //2.获得初始化参数 -- 需要在web.xml中添加<context-param>
        String driver = context.getInitParameter("driver");
        System.out.println(driver);
        //3.获取a、b、c、d 四个txt文件
        //3.1获取a.txt
        String realPath_A = context.getRealPath("/a.txt");
        System.out.println(realPath_A);
        //3.2获取b.txt
        String realPath_B = context.getRealPath("/WEB_INF/b.txt");
        System.out.println(realPath_B);
        //3.1获取c.txt
        String realPath_C = context.getRealPath("/WEB_INF/classes/c.txt");
        System.out.println(realPath_C);

    }
}
