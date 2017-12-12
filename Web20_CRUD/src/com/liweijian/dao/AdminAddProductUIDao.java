package com.liweijian.dao;

import com.liweijian.domain.Category;
import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:55 2017/12/8 0008
 */
public class AdminAddProductUIDao {
    public List<Category> findAllCategory() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from category";
        List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));

        return categoryList;
    }
}
