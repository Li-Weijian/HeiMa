package com.liweijian.dao.impl;

import com.liweijian.dao.BaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 19:31 2018/1/27 0027
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class clazz;

    public BaseDaoImpl() {
        /*
        *  在运行时获取该方法的父类，也就是BaseDao，因为在运行时，一般是某个具体业务dao在运行，且该dao类实现了此接口
        *  getActualTypeArguments: 获取泛型。因为考虑到多泛型，所以返回一个数组，但是我们在此处只有一个泛型
        * */
        ParameterizedType ptType = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) ptType.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        getHibernateTemplate().update(t);
    }

    @Override
    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }

    @Override
    public void delete(Serializable id) {
        T t = this.getByid(id);
        getHibernateTemplate().delete(t);
    }

    @Override
    public T getByid(Serializable id) {
        return (T) getHibernateTemplate().get(clazz, id);
    }

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
    public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
        List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
        return list;
    }
}
