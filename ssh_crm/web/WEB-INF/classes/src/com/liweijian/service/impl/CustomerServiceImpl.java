package com.liweijian.service.impl;

import com.liweijian.dao.CustomerDao;
import com.liweijian.domain.Customer;
import com.liweijian.service.CustomerService;
import com.liweijian.utils.PageBean;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:46 2018/1/25 0025
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Override
    //获取页面数据
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {

        //1.查询总记录数
        Integer totalCount = customerDao.getTotalCount(dc);

        //2.封装PageBean,计算总页数
        PageBean pageBean = new PageBean(totalCount,pageSize,currentPage);

        //3.查询客户列表 -- 分页
        List<Customer> list = customerDao.getCustomerList(dc,pageBean.getStart(),pageBean.getPageSize());
        System.out.println(list.size());
        pageBean.setList(list);

        //4.返回PageBean
        return pageBean;
    }


    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
