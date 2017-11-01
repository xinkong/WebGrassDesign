package com.grass.mapper;

import com.grass.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huchao on 2017/10/27.
 */
public interface UserMapper {

    /**
     * 插入用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据用户ID查找用户
     * @param userId
     */
    User findUserById(long userId);

    /**
     * 登录,更具用户名密码匹配
     * @param userName
     * @param userPwd
     * @return
     */
    User login(@Param("userName") String userName,@Param("userPwd") String userPwd);
}
