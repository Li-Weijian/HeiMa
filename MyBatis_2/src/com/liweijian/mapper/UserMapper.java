package com.liweijian.mapper;

import com.liweijian.pojo.QueryVo;
import com.liweijian.pojo.User;

import java.util.List;

public interface UserMapper {

    //遵循四个原则
    //接口 方法名  == UserMapper.xml 中 id 名
    //返回值类型  与  Mapper.xml文件中返回值类型要一致
    //方法的入参类型 与Mapper.xml中入参的类型要一致
    //命名空间 绑定此接口

    //根据id查找用户
    public User findUserById(Integer id);


    //根据用户名称模糊查询用户列表
    public List<User> findUserByUsername(String username);

    //添加用户
    public void insertUser(User user);

    //更新用户
    public void updateUserById(User user);

    //删除用户
    public void deleteUserById (User user);

    //根据用户名模糊查询用户信息
    public List<User> selectUserByQueryVo(QueryVo vo);

    //查询用户表数据条数
    public Integer UserCount();

    //根据性别和名字查询用户
    public List<User> selectUserBySexAndUsername(User user);
    public List<User> selectUserBySexAndUsername(QueryVo vo);
}
