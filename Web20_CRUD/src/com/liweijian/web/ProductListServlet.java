package com.liweijian.web;

import com.liweijian.domain.Product;
import com.liweijian.service.ProductListService;
import com.liweijian.vo.PageBean;

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
 * @Description: 前台商品列表
 * @Date:Create in 21:35 2017/12/11 0011
 */
@WebServlet(name = "ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductListService service = new ProductListService();
        List<Product> productList = null;
        PageBean pageBean = new PageBean();   /*封装一个对象，存储需要向页面传递的数据*/


        String cueerntPageStr = request.getParameter("cueerntPage");
        if (cueerntPageStr == null) cueerntPageStr = "1";       //默认第一页
        int cueerntPage = Integer.parseInt(cueerntPageStr);
        int cueerntCount = 12;

        try {
            pageBean = service.findPageBean(cueerntPage,cueerntCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher(request.getContextPath() + "/product_list.jsp").forward(request,response);
    }
}
