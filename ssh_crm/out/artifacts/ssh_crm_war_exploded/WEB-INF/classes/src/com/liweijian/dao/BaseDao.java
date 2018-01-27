package com.liweijian.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 19:17 2018/1/27 0027
 */
public interface BaseDao<T> {

    //增
    public void save(T t);
    //改
    public void update(T t);
    //删 删除整体
    public void delete(T t);
    //删 根据id -- 八大基本数据类型都实现了Serializable接口
    public void delete(Serializable id);
    //查  根据id查询
    public T getByid(Serializable id);
    //查  查询总记录数
    public Integer getTotalCount(DetachedCriteria dc);
    //查 查询分页列表
    public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

}
