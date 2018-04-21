package com.liweijian.crm.service;


import com.liweijian.crm.dao.CustomerDao;
import com.liweijian.crm.pojo.Customer;
import com.liweijian.crm.pojo.QueryVo;
import com.liweijian.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Override
    public Page<Customer> selectPageByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<>();
        page.setSize(5);
        vo.setSize(page.getSize());

        if (null != vo){
            //判断当前页
            if (null != vo.getPage()){
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() -1)*vo.getSize());
            }
            if (null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
                vo.setCustName(vo.getCustName().trim());
            }
            if (null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
                vo.setCustSource(vo.getCustSource().trim());
            }
            if (null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if (null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            //总条数
            page.setTotal(customerDao.customerCount(vo));
            page.setRows(customerDao.selectPageByQueryVo(vo));
        }

        return page;
    }

    @Override
    public Customer selectCustomerById(String id) {
        return customerDao.selectCustomerById(id);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        customerDao.updateCustomerById(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteCustomerById(id);
    }


}
