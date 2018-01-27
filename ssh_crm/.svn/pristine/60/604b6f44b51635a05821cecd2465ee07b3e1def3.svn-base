package com.liweijian.dao.impl;

import com.liweijian.dao.CustomerDao;
import com.liweijian.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:59 2018/1/25 0025
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public Integer getTotalCount(DetachedCriteria dc) {
        //设置聚合函数条件
        dc.setProjection(Projections.rowCount());

        //查询
        List<Long> count = (List<Long>) getHibernateTemplate().findByCriteria(dc);
        //清空聚合函数条件
        dc.setProjection(null);

        if (count != null && count.size() > 0){
            int totalCount = count.get(0).intValue();
            return totalCount;
        }else {
            return null;
        }

    }

    @Override
    public List<Customer> getCustomerList(DetachedCriteria dc, Integer start, Integer pageSize) {
        List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
        return list;

    }
}
