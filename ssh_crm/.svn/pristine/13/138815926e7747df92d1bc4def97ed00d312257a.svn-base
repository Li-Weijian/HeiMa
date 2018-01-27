package com.liweijian.dao.impl;

import com.liweijian.dao.UserDao;
import com.liweijian.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 19:35 2018/1/24 0024
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {


    @Override
    public User getByUserCode(String userCode) {


        //hql查询
        return getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {

                String hql = "from User where user_code = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0,userCode);
                User u = (User) query.uniqueResult();
                return u;
            }
        });

        //Criteria查询
       /* DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("user_code",userCode));

        List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);

        //只会查询出一个结果。因此只需要返回第一个元素即可
        if (list != null && list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
*/
    }

}
