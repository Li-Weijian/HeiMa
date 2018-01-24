package com.liweijian.service;

import com.liweijian.domain.User; /**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:48 2018/1/23 0023
 */
public interface UserService {
    //登录
    User getUserByCodePassword(User user);

    //注册(保存)
    void save(User user);
}
