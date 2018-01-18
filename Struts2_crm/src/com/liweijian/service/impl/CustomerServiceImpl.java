package com.liweijian.service.impl;

import com.liweijian.dao.CustomerDao;
import com.liweijian.dao.impl.CustomerDaoImpl;
import com.liweijian.domain.Customer;
import com.liweijian.service.CustomerService;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:41 2018/1/6 0006
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao;

    @Override
    public void addCustomer(Customer customer) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            dao.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    //根据id查询Customer
    @Override
    public Customer findCustomerByid(Long cust_id) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Customer customer = null;
        try {
            customer = dao.findCustomerByid(cust_id);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

        return customer;
    }

    @Override
    public List<Customer> customerList(DetachedCriteria dc) {
        List<Customer> customerList = null;
        customerList = dao.customerList(dc);
        return customerList;
    }

    @Override
    public List<Customer> customerList() {
        List<Customer> customerList = null;
        customerList = dao.customerList();
        return customerList;
    }


    public CustomerDao getDao() {
        return dao;
    }

    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }
}
