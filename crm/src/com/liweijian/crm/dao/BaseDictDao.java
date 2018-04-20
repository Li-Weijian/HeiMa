package com.liweijian.crm.dao;

import com.liweijian.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao {

    /**
     * 根据code查询数据字典
     * */
    public List<BaseDict> selectBaseDictByCode(String code);

}
