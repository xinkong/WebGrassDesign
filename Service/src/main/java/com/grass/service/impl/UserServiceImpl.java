package com.grass.service.impl;

import com.grass.entity.User;
import com.grass.exception.BusinessException;
import com.grass.mapper.UserMapper;
import com.grass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huchao on 2017/10/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User login(String userName, String userPwd) {
        User login = userMapper.login(userName, userPwd);
        if(login == null){
            throw new BusinessException("EG-U-001");
        }
        return login;
    }
}
