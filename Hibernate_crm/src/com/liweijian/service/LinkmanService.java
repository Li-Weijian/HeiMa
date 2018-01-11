package com.liweijian.service;

import com.liweijian.domain.Customer;
import com.liweijian.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 10:45 2018/1/9 0009
 */
public interface LinkmanService {



    void addLinkman(Linkman linkman);

    List<Linkman> findAllLinkman();

    List<Linkman> findAllLinkman(DetachedCriteria dc);
}
