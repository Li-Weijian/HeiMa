package com.liweijian.service.impl;

import com.liweijian.dao.LinkmanDao;
import com.liweijian.domain.Linkman;
import com.liweijian.service.LinkmanService;
import com.liweijian.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:01 2018/1/29 0029
 */
public class LinkManServiceImpl implements LinkmanService {

    private LinkmanDao lmDao;


    @Override
    public void save(Linkman linkman) {
        lmDao.save(linkman);
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //1.查询总记录数
        Integer totalCount = lmDao.getTotalCount(dc);

        //2.封装PageBean,计算总页数
        PageBean pageBean = new PageBean(totalCount,pageSize,currentPage);

        //3.查询客户列表 -- 分页
        List<Linkman> list = lmDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
        pageBean.setList(list);

        //4.返回PageBean
        return pageBean;
    }

    @Override
    public Linkman getLinkmanById(Long lkm_id) {
        return lmDao.getByid(lkm_id);
    }

    @Override
    public void update(Linkman linkman) {
        lmDao.update(linkman);
    }


    public void setLmDao(LinkmanDao lmDao) {
        this.lmDao = lmDao;
    }
}
