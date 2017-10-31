package com.grass.service;

import com.grass.entity.User;

/**
 * Created by huchao on 2017/10/27.
 */
public interface UserService {
    /**
     * 注册
     * @param user
     */
    void register(User user);

    /**
     * 登录
     * @param userName
     * @param userPwd
     */
    User login(String userName,String userPwd);

}
