package com.liweijian.crm.service;

import com.liweijian.crm.dao.BaseDictDao;
import com.liweijian.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> selectBaseDictByCode(String code) {
        List<BaseDict> baseDict = baseDictDao.selectBaseDictByCode(code);
        return baseDict;
    }
}
