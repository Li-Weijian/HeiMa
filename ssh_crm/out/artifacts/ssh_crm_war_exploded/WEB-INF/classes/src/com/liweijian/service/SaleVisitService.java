package com.liweijian.service;

import com.liweijian.domain.SaleVisit;
import com.liweijian.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria; /**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:20 2018/1/31 0031
 */
public interface SaleVisitService {

    //保存拜访记录
    void save(SaleVisit saleVisit);
    //分页列表
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
    //根据id获取拜访记录
    SaleVisit getSaleVIsitById(String visit_id);
    //更新拜访记录
    void update(SaleVisit saleVisit);
}
