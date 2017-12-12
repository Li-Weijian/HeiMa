package com.liweijian.dao;

import com.liweijian.domain.Product;
import com.liweijian.utils.DataSourceUtils;
import com.liweijian.vo.Condition;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:07 2017/12/10 0010
 */
public class AdminSearchProductListDao {
    public List<Product> searchProductList(Condition condition) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        List<String> list = new ArrayList<>();      /*定义存储sql参数的容器*/

        //采用字符串拼接的方式拼接条件
        String sql = "select * from product where 1=1";
        if (condition.getPname()!=null && !condition.getPname().trim().equals("")){
            sql += " and pname like ? ";
            list.add("%" + condition.getPname().trim() +"%");
        }
        if (condition.getCid()!=null && !condition.getCid().trim().equals("")){
            sql += " and cid = ? ";
            list.add(condition.getCid().trim());
        }
        if (condition.getIs_hot()!=null && !condition.getIs_hot().trim().equals("")){
            sql += " and is_hot = ? ";
            list.add(condition.getIs_hot().trim());
        }

        List<Product> productList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), list.toArray());
        return productList;
    }
}
