package com.liweijian.vo;

import com.liweijian.domain.Product;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:57 2017/12/11 0011
 */
public class PageBean {

    //当前页
    private int cueerntPage;
    //当前显示的商品数目
    private int cueerntCount;
    //总条数
    private int totalCount;
    //总页数
    private int totalPage;
    //每页显示的商品
    private List<Product> productList;

    public void setCueerntPage(int cueerntPage) {
        this.cueerntPage = cueerntPage;
    }

    public void setCueerntCount(int cueerntCount) {
        this.cueerntCount = cueerntCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getCueerntPage() {
        return cueerntPage;
    }

    public int getCueerntCount() {
        return cueerntCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
