package liweijian.jsp.servlet;

import liweijian.jsp.domain.Product;
import liweijian.jsp.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
 * @Description:
 * @Date:Create in 21:48 2017/12/3 0003
 */
@WebServlet(name = "ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从数据库获取数据
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product";
        try {
            List<Product> productlist = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));

            //2.将数据转发到jsp中进行显示
            request.setAttribute("productlist",productlist);
            request.getRequestDispatcher("/product_list.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
