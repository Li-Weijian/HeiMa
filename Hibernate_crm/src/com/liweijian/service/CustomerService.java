package com.liweijian.service;

import com.liweijian.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:40 2018/1/6 0006
 */
public interface CustomerService {
    //保存客户
    public void addCustomer(Customer customer);

    List<Customer> customerList();

    Customer findCustomerByid(Long cust_id);

    List<Customer> customerList(DetachedCriteria dc);
}
