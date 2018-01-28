package com.liweijian.dao.impl;

import com.liweijian.dao.BaseDictDao;
import com.liweijian.domain.BaseDict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:16 2018/1/28 0028
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

    @Override
    public List<BaseDict> getBaseDictByTypeCode(String dict_type_code) {

        DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
        dc.add(Restrictions.eq("dict_type_code",dict_type_code));

        List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);

        return list;
    }
}
