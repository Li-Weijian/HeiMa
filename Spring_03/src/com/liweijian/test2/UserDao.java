package com.liweijian.test2;

import com.liweijian.bean.User;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:02 2018/1/22 0022
 */
public interface UserDao {
    public void save(User user);
    public void delete(Integer id);
    public void update(User user);
    public User getById(Integer id);
    public int getByTotalCount();
    public List<User> getAll();

}
