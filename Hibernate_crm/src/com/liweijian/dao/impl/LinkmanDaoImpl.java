package com.liweijian.dao.impl;

import com.liweijian.dao.LinkmanDao;
import com.liweijian.domain.Linkman;
import com.liweijian.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 10:47 2018/1/9 0009
 */
public class LinkmanDaoImpl implements LinkmanDao {
    @Override
    public void addLinkman(Linkman linkman) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(linkman);
    }

    @Override
    public List<Linkman> findAllLinkman() {
        Session session = HibernateUtils.getCurrentSession();
        String hql = "from Linkman";
        return session.createQuery(hql).list();
    }

    @Override
    public List<Linkman> findAllLinkman(DetachedCriteria dc) {
        Session session = HibernateUtils.getCurrentSession();
        //关联Session得到可执行的Criteria
        Criteria criteria = dc.getExecutableCriteria(session);
        return  criteria.list();

    }
}
