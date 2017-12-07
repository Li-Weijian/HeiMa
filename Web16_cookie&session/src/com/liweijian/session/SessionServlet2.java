package com.liweijian.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:32 2017/11/21 0021
 */
@WebServlet(name = "SessionServlet2")
public class SessionServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        //获取session1中存储的数据
        //如果在cookie未持久化且未访问session1的情况下访问session2，则取不到数据
        //解决方法是，设置session持久化，请参考session1
        String name = (String)session.getAttribute("name");

        response.getWriter().write(name);
    }
}
