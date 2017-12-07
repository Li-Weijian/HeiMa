package com.liweijian.web;

import com.liweijian.domain.Product;
import com.liweijian.service.ProductListService;

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
 * @Description: web层
 * @Date:Create in 13:47 2017/12/6 0006
 */
@WebServlet(name = "ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.传递数据到service层
        ProductListService service = new ProductListService();
        List<Product> productList = null;
        try {
            productList = service.findAllProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //2.将从数据库取回的数据转发到jsp进行显示
        request.setAttribute("productList",productList);
        request.getRequestDispatcher(request.getContextPath()+"/product_list.jsp").forward(request,response);
    }
}
