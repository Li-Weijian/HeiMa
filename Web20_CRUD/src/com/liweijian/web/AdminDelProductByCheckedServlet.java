package com.liweijian.web;

import com.liweijian.service.AdminDelProductByCheckedService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author:Liweijian
 * @Description: 多选删除功能
 * @Date:Create in 21:38 2017/12/9 0009
 */
@WebServlet(name = "AdminDelProductByCheckedServlet")
public class AdminDelProductByCheckedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkProduct = request.getParameter("checkProduct");
//        System.out.println(checkProduct);

        String uid[] = checkProduct.split(",");

        AdminDelProductByCheckedService service = new AdminDelProductByCheckedService();
        try {
            service.delProductByChecked(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath()+"/adminProductList");
/*        for (int i = 0; i < uid.length; i++){
            System.out.println(uid[i]);
        }*/
    }
}
