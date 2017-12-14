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
 * @Description: 活化Customer
 * @Date:Create in 16:19 2017/12/14 0014
 */
@WebServlet(name = "TestSessionActivationServlet2")
public class TestSessionActivationServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String name = customer.getName();
        System.out.println(name);
    }
}
