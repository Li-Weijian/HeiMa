package com.liweijian.web;

import com.liweijian.domain.Category;
import com.liweijian.domain.Product;
import com.liweijian.service.AdminAddProductUIService;
import com.liweijian.service.AdminEditProductUIService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description: 编辑页面的回显功能
 * @Date:Create in 10:44 2017/12/10 0010
 */
@WebServlet(name = "AdminEditProductUIServlet")
public class AdminEditProductUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        Product product = null;

        //根据Pid获取Product
        AdminEditProductUIService service = new AdminEditProductUIService();
        try {
            product = service.findProductById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取类别
        AdminAddProductUIService service1 = new AdminAddProductUIService();
        List<Category> categoryList = null;
        try {
            categoryList = service1.findAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("categoryList",categoryList);
        request.setAttribute("product",product);
        request.getRequestDispatcher(request.getContextPath()+"/admin/product/edit.jsp").forward(request,response);
    }
}
