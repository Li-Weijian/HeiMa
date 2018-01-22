package com.liweijian.service;

/**
 * @Author:Liweijian
 * @Description: 目标对象
 * @Date:Create in 16:38 2018/1/20 0020
 */
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("添加");
    }

    @Override
    public void delete() {
        System.out.println("删除");

    }

    @Override
    public void update() {
        System.out.println("更新");

    }

    @Override
    public void find() {
        System.out.println("查找 ");

    }
}
