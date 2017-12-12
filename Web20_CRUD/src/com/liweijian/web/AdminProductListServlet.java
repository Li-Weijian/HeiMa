package com.liweijian.web;

import com.liweijian.domain.Category;
import com.liweijian.domain.Product;
import com.liweijian.service.AdminAddProductUIService;
import com.liweijian.service.AdminProductListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:15 2017/12/8 0008
 */
public class AdminProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminProductListService service = new AdminProductListService();
       List<Product> productList =  service.findAllProduct();

        AdminAddProductUIService addService = new AdminAddProductUIService();
        List<Category> categoryList = null;

        try {
            categoryList = addService.findAllCategory();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("categoryList",categoryList);
       request.setAttribute("productList",productList);
       request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
    }
}
