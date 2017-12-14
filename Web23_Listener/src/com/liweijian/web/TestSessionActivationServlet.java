package com.liweijian.web;

import com.liweijian.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description: SessionActivationListener测试
 * @Date:Create in 16:08 2017/12/14 0014
 */
@WebServlet(name = "TestSessionActivationServlet")
public class TestSessionActivationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Customer customer = new Customer();
        customer.setId("200");
        customer.setName("wangwu");

        session.setAttribute("customer",customer);
    }
}
