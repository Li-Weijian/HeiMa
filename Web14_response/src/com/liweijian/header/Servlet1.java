package com.liweijian.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: 重定向测试 -- 将Servlet1重定向到Servlet2
 * @Date:Create in 21:01 2017/11/15 0015
 */
@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  //设置重定向状态码
        response.setStatus(302);

        //设置重定向地址
        response.addHeader("Location","/servlet2");*/

      //java为我们封装了重定向方法
        response.sendRedirect("/servlet2");
    }
}
