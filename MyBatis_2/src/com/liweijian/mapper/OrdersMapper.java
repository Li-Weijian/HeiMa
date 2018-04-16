package com.liweijian.mapper;

import com.liweijian.pojo.Orders;
import com.liweijian.pojo.QueryVo;
import com.liweijian.pojo.User;

import java.util.List;

public interface OrdersMapper {


//    查询订单表order的所有数据
        public List<Orders> selectAllOrders();

//    查询所有订单信息，关联查询下单用户信息
        public List<Orders> selectOrdersOfUser();

    //查询所有用户信息及用户关联的订单信息。
    public List<User> selectUserAndOrders();
}
