package com.liweijian.service.impl;

import com.liweijian.dao.SaleVisitDao;
import com.liweijian.domain.Linkman;
import com.liweijian.domain.SaleVisit;
import com.liweijian.domain.User;
import com.liweijian.service.SaleVisitService;
import com.liweijian.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:20 2018/1/31 0031
 */
public class SaleVisitServiceImpl implements SaleVisitService {

    private SaleVisitDao saleVisitDao;

    @Override
    //保存拜访记录
    public void save(SaleVisit saleVisit) {
        User user = (User) ActionContext.getContext().getSession().get("user");
        saleVisit.setUser(user);
        saleVisitDao.save(saleVisit);
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //1.查询总记录数
        Integer totalCount = saleVisitDao.getTotalCount(dc);

        //2.封装PageBean,计算总页数
        PageBean pageBean = new PageBean(totalCount,pageSize,currentPage);

        //3.查询客户列表 -- 分页
        List<SaleVisit> list = saleVisitDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
        pageBean.setList(list);

        //4.返回PageBean
        return pageBean;
    }

    @Override
    public SaleVisit getSaleVIsitById(String visit_id) {
        return saleVisitDao.getByid(visit_id);
    }

    @Override
    public void update(SaleVisit saleVisit) {
        saleVisitDao.update(saleVisit);
    }


    public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
        this.saleVisitDao = saleVisitDao;
    }
}
