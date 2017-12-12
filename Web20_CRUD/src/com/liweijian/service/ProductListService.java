package com.liweijian.service;

import com.liweijian.dao.ProductListDao;
import com.liweijian.domain.Product;
import com.liweijian.vo.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:39 2017/12/11 0011
 */
public class ProductListService {
    public List<Product> findAllProduct() throws SQLException {
        return new ProductListDao().findAllProduct();
    }

    public PageBean findPageBean(int cueerntPage, int cueerntCount) throws SQLException{

        PageBean pageBean = new PageBean();
        ProductListDao dao = new ProductListDao();

        //1.当前页private int cueerntPage;
        pageBean.setCueerntPage(cueerntPage);
        //2.当前显示的商品数目 private int cueerntCount;
        pageBean.setCueerntCount(cueerntCount);
        //3.总条数private int totalCount;
        int totalCount = dao.getTotalCount();
        pageBean.setTotalCount(totalCount);
        //4.总页数 private int totalPage;  ---
        /*
        *   商品总数        每页显示商品      总页数
        *       10              4               3
        *       11              4               3
        *       12              4               3
        *
        *   公式：总页数 = Math.ceil（商品总数 / 每页显示商品数）  向上取整
        * */
        int totalPage = (int) Math.ceil(1.0*totalCount / cueerntCount);
        pageBean.setTotalPage(totalPage);
        //5.每页显示的商品private List<Product> productList;
        /*
        *   当前页         每页显示商品      起始索引
        *      1                4               0
        *      2                4               4
        *      3                4               8
        *
        *   公式： 起始索引 = （当前页-1）* 每页显示商品
        * */
        int index = (cueerntPage - 1) * cueerntCount;
        List<Product> productList = dao.findProductListFroPageBean(index, cueerntCount);
        pageBean.setProductList(productList);


        return pageBean;

    }
}
