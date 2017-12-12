package com.liweijian.web;

import com.liweijian.service.AdminDelProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: 删除模块的实现类
 * @Date:Create in 20:53 2017/12/9 0009
 */
@WebServlet(name = "AdminDelProductServlet")
public class AdminDelProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");

        AdminDelProductService service = new AdminDelProductService();
        try {
          service.delProduct(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath()+"/adminProductList");
    }
}
