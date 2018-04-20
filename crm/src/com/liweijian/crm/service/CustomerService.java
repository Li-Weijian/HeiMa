package com.liweijian.crm.service;

import com.liweijian.crm.pojo.Customer;
import com.liweijian.crm.pojo.QueryVo;
import com.liweijian.crm.utils.Page;

import java.util.List;

public interface CustomerService {

    public Page<Customer> selectPageByQueryVo(QueryVo vo);


}
