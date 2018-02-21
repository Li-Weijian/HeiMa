package com.liweijian.service.impl;

import com.liweijian.dao.CustomerDao;
import com.liweijian.entity.Customer;
import com.liweijian.service.CustomerService;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 20:59 2018/2/20 0020
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public Customer findCustomerById(Long id) {

        return customerDao.findCustomerById(id) ;
    }


    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
