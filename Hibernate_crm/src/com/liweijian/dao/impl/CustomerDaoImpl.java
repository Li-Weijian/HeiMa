package com.liweijian.dao.impl;

import com.liweijian.dao.CustomerDao;
import com.liweijian.domain.Customer;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:44 2018/1/6 0006
 */

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void addCustomer(Customer customer) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(customer);
    }

    @Override
    public List<Customer> customerList() {
        Session session = HibernateUtils.openSession();
        String hql = "from Customer ";
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();
        return list;
    }

    @Override
    public Customer findCustomerByid(Long cust_id) {
        Session session = HibernateUtils.getCurrentSession();
//        Criteria criteria = session.createCriteria(Customer.class);
//        criteria.add(Restrictions.eq("cust_id",cust_id));
//        Customer customer = (Customer) criteria.uniqueResult();
        return session.get(Customer.class,cust_id);
    }

    @Override
    public List<Customer> customerList(DetachedCriteria dc) {
        Session session = HibernateUtils.openSession();
        Criteria criteria = dc.getExecutableCriteria(session);
        return criteria.list();
    }
}
