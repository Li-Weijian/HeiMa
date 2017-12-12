package com.liweijian.web;

import com.liweijian.domain.Category;
import com.liweijian.service.AdminAddProductUIService;

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
 * @Description: 添加页面类别数据准备servlet
 * @Date:Create in 22:46 2017/12/8 0008
 */
@WebServlet(name = "AdminAddProductUIServlet")
public class AdminAddProductUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AdminAddProductUIService service = new AdminAddProductUIService();
        List<Category> categoryList = null;

        try {
            categoryList = service.findAllCategory();
          /*  for (Category categorie: categoryList){
                System.out.println(categorie.getCname());
            }*/

            request.setAttribute("categoryList",categoryList);
            request.getRequestDispatcher("/admin/product/add.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
