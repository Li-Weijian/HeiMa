package com.liweijian.crm.dao;

import com.liweijian.crm.pojo.Customer;
import com.liweijian.crm.pojo.QueryVo;
import com.liweijian.crm.utils.Page;

import java.util.List;

public interface CustomerDao {

    /**
     * 查询分页数据
     * */
    public List<Customer> selectPageByQueryVo(QueryVo vo);

    /**
     * 查询总记录数
     * */
    public Integer customerCount(QueryVo vo);

}
