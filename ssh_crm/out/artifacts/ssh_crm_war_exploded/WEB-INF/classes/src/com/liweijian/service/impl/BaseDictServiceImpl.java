package com.liweijian.service.impl;

import com.liweijian.dao.BaseDictDao;
import com.liweijian.domain.BaseDict;
import com.liweijian.service.BaseDictService;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:14 2018/1/28 0028
 */
public class BaseDictServiceImpl implements BaseDictService {

    private BaseDictDao bdDao;

    @Override
    public List<BaseDict> getBaseDictByTypeCode(String dict_type_code) {
       return bdDao.getBaseDictByTypeCode(dict_type_code);
    }


    public void setBdDao(BaseDictDao bdDao) {
        this.bdDao = bdDao;
    }
}
