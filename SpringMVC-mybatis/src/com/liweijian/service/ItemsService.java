package com.liweijian.service;

import com.liweijian.pojo.Items;

import java.util.List;

public interface ItemsService {

    //查询所有商品
    public List<Items> selectItemsList();

    //根据id查询商品
    public Items selectItemsById(Integer id);

    //更新商品
    public void updateItem(Items items);

}
