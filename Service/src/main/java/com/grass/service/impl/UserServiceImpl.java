package com.grass.service.impl;

import com.grass.entity.User;
import com.grass.exception.BusinessException;
import com.grass.mapper.UserMapper;
import com.grass.service.UserService;
import com.grass.utils.PropertyUtil;
import com.grass.utils.Tools;
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
        User userByName = userMapper.findUserByName(user.getUserName());
        if (userByName != null) {
            throw new BusinessException("EG-U-004");
        }
        userMapper.insertUser(user);
    }

    @Override
    public User login(String userName, String userPwd) {

        if (Tools.getStringIsNull(userName) || Tools.getStringIsNull(userPwd)) {
            throw new BusinessException("EG-U-003");
        }

        User login = userMapper.login(userName, userPwd);
        if (login == null) {
            throw new BusinessException("EG-U-001");
        }
        if (!Tools.getStringIsNull(login.getUserHeadPic())) {
            login.setUserHeadPic(Tools.getUploadFilePath() + login.getUserHeadPic());
        }
        return login;
    }

    @Override
    public User updateUser(User user) {
        if (Tools.getStringIsNull(user.getUserHeadPic()) && Tools.getStringIsNull(user.getUserName()) && Tools.getStringIsNull(user.getUserPwd())) {
            throw new BusinessException("EG-U-002");
        }
        userMapper.updateUser(user);
        if (!Tools.getStringIsNull(user.getUserHeadPic())) {
            user.setUserHeadPic(Tools.getUploadFilePath() + user.getUserHeadPic());
        }
        return user;
    }
}
