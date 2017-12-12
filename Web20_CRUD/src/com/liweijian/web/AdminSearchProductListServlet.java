package com.liweijian.web;

import com.liweijian.domain.Category;
import com.liweijian.domain.Product;
import com.liweijian.service.AdminAddProductUIService;
import com.liweijian.service.AdminSearchProductListService;
import com.liweijian.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author:Liweijian
 * @Description: 搜索功能实现类
 * @Date:Create in 22:00 2017/12/10 0010
 */
@WebServlet(name = "AdminSearchProductListServlet")
public class AdminSearchProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> properties = request.getParameterMap();
        Condition condition = new Condition();
        List<Product> productList = null;

        //封装条件Bean
        try {
            BeanUtils.populate(condition,properties);

            AdminSearchProductListService service = new AdminSearchProductListService();
            try {
                productList  = service.searchProductList(condition);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        AdminAddProductUIService addService = new AdminAddProductUIService();
        List<Category> categoryList = null;

        try {
            categoryList = addService.findAllCategory();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("condition",condition);
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("productList",productList);
        request.getRequestDispatcher(request.getContextPath() + "/admin/product/list.jsp").forward(request,response);

    }
}
