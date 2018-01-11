package com.liweijian.service.impl;

import com.liweijian.dao.CustomerDao;
import com.liweijian.dao.LinkmanDao;
import com.liweijian.dao.impl.CustomerDaoImpl;
import com.liweijian.dao.impl.LinkmanDaoImpl;
import com.liweijian.domain.Customer;
import com.liweijian.domain.Linkman;
import com.liweijian.service.LinkmanService;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 10:46 2018/1/9 0009
 */
public class LinkmanServiceImpl implements LinkmanService {

    private LinkmanDao dao = new LinkmanDaoImpl();
    private CustomerDao cust_dao = new CustomerDaoImpl();


    //添加联系人
    @Override
    public void addLinkman(Linkman linkman) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            dao.addLinkman(linkman);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    //查询所有联系人
    @Override
    public List<Linkman> findAllLinkman() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Linkman> linkmanList = null;
        try {
            linkmanList = dao.findAllLinkman();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

        return linkmanList;
    }

    @Override
    public List<Linkman> findAllLinkman(DetachedCriteria dc) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Linkman> linkmanList = null;
        try {
            linkmanList = dao.findAllLinkman(dc);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

        return linkmanList;
    }
}
