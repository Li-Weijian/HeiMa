package com.liweijian.dao.impl;

import com.liweijian.dao.CustomerDao;
import com.liweijian.entity.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 20:34 2018/2/20 0020
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    public Customer findCustomerById(Long id) {
        return this.getHibernateTemplate().get(Customer.class,id);
    }
}
