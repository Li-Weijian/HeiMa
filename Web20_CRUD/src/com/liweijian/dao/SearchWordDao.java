package com.liweijian.dao;

import com.liweijian.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 16:15 2017/12/13 0013
 */
public class SearchWordDao {
    public List<Object> findAllProductFroWord(String word) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from product where pname like ? limit 0,8";     //最多显示八个
        List<Object> productWord = queryRunner.query(sql, new ColumnListHandler("pname"), "%" + word + "%");

        return productWord;
    }
}
