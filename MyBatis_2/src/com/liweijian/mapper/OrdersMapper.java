package com.liweijian.mapper;

import com.liweijian.pojo.Orders;
import com.liweijian.pojo.QueryVo;
import com.liweijian.pojo.User;

import java.util.List;

public interface OrdersMapper {


//    查询订单表order的所有数据
        public List<Orders> selectAllOrders();
}
