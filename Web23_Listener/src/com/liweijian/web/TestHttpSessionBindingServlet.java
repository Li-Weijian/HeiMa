package com.liweijian.web;

import com.liweijian.domain.Peoper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: 测试HttpSessionBindingListener
 * @Date:Create in 15:47 2017/12/14 0014
 */
@WebServlet(name = "TestHttpSessionBindingServlet")
public class TestHttpSessionBindingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Peoper peoper = new Peoper();
        peoper.setId("100");
        peoper.setName("lisi");
        session.setAttribute("peoper",peoper);


        //1.销毁session  -- peoper被解绑
        //2.客户端超过会话时间，session将被销毁
        session.invalidate();


    }
}
