package com.liweijian.service;

import com.liweijian.dao.AdminSearchProductListDao;
import com.liweijian.domain.Product;
import com.liweijian.vo.Condition;
import com.liweijian.web.AdminSearchProductListServlet;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:06 2017/12/10 0010
 */
public class AdminSearchProductListService {
    public List<Product> searchProductList(Condition condition) throws SQLException {

        AdminSearchProductListDao dao = new AdminSearchProductListDao();
        return dao.searchProductList(condition);

    }
}
