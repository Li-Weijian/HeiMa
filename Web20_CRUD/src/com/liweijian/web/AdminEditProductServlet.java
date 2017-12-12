package com.liweijian.web;

import com.liweijian.domain.Product;
import com.liweijian.service.AdminEditProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author:Liweijian
 * @Description: 编辑功能实现类
 * @Date:Create in 19:21 2017/12/10 0010
 */
@WebServlet(name = "AdminEditProductServlet")
public class AdminEditProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


        Map<String, String[]> properties = request.getParameterMap();
        Product product = new Product();

        try {
            BeanUtils.populate(product,properties);
            product.setPimage("products/1/c_0012.jpg");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String pdate = format.format(new Date());
            product.setPdate(pdate);
            product.setPflag(0);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        AdminEditProductService service = new AdminEditProductService();
        try {
            service.updateProductById(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/adminProductList");
    }
}
