package com.liweijian.crm.service;

import com.liweijian.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {

    /**
     * 根据code查询数据字典
     * */
    public List<BaseDict> selectBaseDictByCode(String code);
}
