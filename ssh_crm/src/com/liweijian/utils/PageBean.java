package com.liweijian.utils;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:21 2018/1/25 0025
 */
public class PageBean {

    //总记录数 -- 调用dao查询
    private Integer totalCount;
    //每页显示条数 -- 页面传入
    private Integer pageSize;
    //总页数 -- 总记录数/每页显示条数
    private Integer totalPage;
    //当前页数 -- 从页面中传入
    private Integer currentPage;
    //数据列表 -- 调用dao查询
    private List list;

    public PageBean(Integer totalCount, Integer pageSize, Integer currentPage) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currentPage = currentPage;

        if (this.currentPage == null || this.currentPage < 1){
            //如果没有指定哪一页，则默认显示第一页
            this.currentPage = 1;
        }

        if (this.pageSize == null){
            //如果没有指定每页显示条数，默认显示3条
            this.pageSize = 3;
        }

        //计算总页数
        this.totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);

        if (this.pageSize > this.totalPage){
            this.pageSize = this.totalPage;
        }
    }


    //获取查询起始位置
    public Integer getStart(){
        return (this.currentPage - 1) * this.pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
