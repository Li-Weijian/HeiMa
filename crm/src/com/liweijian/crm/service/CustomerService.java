package com.liweijian.crm.service;

import com.liweijian.crm.pojo.Customer;
import com.liweijian.crm.pojo.QueryVo;
import com.liweijian.crm.utils.Page;

import java.util.List;

public interface CustomerService {

    /**
     * 查询分页数据
     * */
    public Page<Customer> selectPageByQueryVo(QueryVo vo);


    /**
     * 根据id查询对象
     * */
    public Customer selectCustomerById(String id);


    /**
     * 更新客户
     * */
    public void updateCustomerById(Customer customer);

    /**
     * 删除客户
     * */
    public void deleteCustomerById(Integer id);
}
