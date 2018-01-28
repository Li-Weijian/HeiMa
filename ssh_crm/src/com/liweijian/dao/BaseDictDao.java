package com.liweijian.dao;

import com.liweijian.domain.BaseDict;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:15 2018/1/28 0028
 */
public interface BaseDictDao extends BaseDao<BaseDict> {
    List<BaseDict> getBaseDictByTypeCode(String dict_type_code);
}
