package com.liweijian.dao;

import com.liweijian.entity.Customer;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 20:33 2018/2/20 0020
 */
public interface CustomerDao {

    /**
     * 根据id查询客户信息
     * */
    public Customer findCustomerById(Long id);

}
