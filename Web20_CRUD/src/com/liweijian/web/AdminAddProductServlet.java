package com.liweijian.web;

import com.liweijian.domain.Product;
import com.liweijian.service.AdminAddProductService;
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
import java.util.UUID;

/**
 * @Author:Liweijian
 * @Description: 添加商品模块
 * @Date:Create in 10:36 2017/12/9 0009
 */
@WebServlet(name = "AdminAddProductServlet")
public class AdminAddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取表单数据
        Map<String, String[]> properties = request.getParameterMap();

        //2.准备实体类
        Product product = new Product();

        try {
            //3.封装数据
            BeanUtils.populate(product,properties);

            //================实体自动封装完毕，表单未包含字段需要手动封装===============//

            //  private String pid;
                //pid字段为varchar类型，长度50，因此可以使用UUID进行随机生成
            product.setPid(UUID.randomUUID().toString());

            //  private String pimage; -- 未实现文件上传，把字段写死
            product.setPimage("products/1/c_0012.jpg");

            //  private String pdate;  -- 上架日期
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String pdate = format.format(new Date());
            product.setPdate(pdate);

            //  private String pflag;  -- 是否下架 0：下架  1：上架
            product.setPflag(0);


            //4.将数据传递到service层
            AdminAddProductService service = new AdminAddProductService();
            try {
                service.addProduct(product);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //5.跳转到列表页面
            response.sendRedirect(request.getContextPath()+"/adminProductList");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
