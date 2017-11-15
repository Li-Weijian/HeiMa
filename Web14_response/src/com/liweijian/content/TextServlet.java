package com.liweijian.content;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:17 2017/11/15 0015
 */
@WebServlet(name = "TextServlet")
public class TextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置服务器向客户端发送文本的编码格式
        //response.setCharacterEncoding("UTF-8");

        //设置客户端解析文本的编码
        //一般在开发中只需要写这一句就可以，不需要 response.setCharacterEncoding("UTF-8");
        //因为调用这句话将自动把编码都设置为utf-8
        //response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("你好");



    }
}
