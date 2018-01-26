package com.liweijian.dao;

import com.liweijian.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:58 2018/1/25 0025
 */
public interface CustomerDao {
    //获得总记录数
    Integer getTotalCount(DetachedCriteria dc);

    //获得分页客户列表
    List<Customer> getCustomerList(DetachedCriteria dc, Integer start, Integer pageSize);
}
