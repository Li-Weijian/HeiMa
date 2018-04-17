package com.liweijian.service;

import com.liweijian.mapper.ItemsMapper;
import com.liweijian.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> selectItemsList() {
        List<Items> itemsList = itemsMapper.selectByExampleWithBLOBs(null);
        return itemsList;
    }

    @Override
    public Items selectItemsById(Integer id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItem(Items items) {
        items.setCreatetime(new Date());
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }
}
