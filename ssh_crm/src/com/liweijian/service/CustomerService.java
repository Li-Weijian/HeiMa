package com.liweijian.service;

import com.liweijian.domain.Customer;
import com.liweijian.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:45 2018/1/25 0025
 */
public interface CustomerService {
    //获取页面数据
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
