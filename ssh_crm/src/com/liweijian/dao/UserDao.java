package com.liweijian.dao;

import com.liweijian.domain.User; /**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 19:35 2018/1/24 0024
 */
public interface UserDao {


    User getByUserCode(String userCode);

    void save(User user);
}
