package com.liweijian.service;

import com.liweijian.domain.Linkman;
import com.liweijian.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria; /**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:00 2018/1/29 0029
 */
public interface LinkmanService {
    //添加联系人
    void save(Linkman linkman);
    //查询联系人
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
