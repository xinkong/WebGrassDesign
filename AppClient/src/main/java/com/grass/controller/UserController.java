package com.grass.controller;

import com.grass.entity.User;
import com.grass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huchao on 2017/10/27.
 */
@Controller
@RequestMapping("/userInfo")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public void register(User user) throws Exception {
        userService.register(user);
        returnBackData("注册成功");
    }

    /**
     * 用户登录
     *
     * @param userName
     * @param userPwd
     * @throws Exception
     */
    @RequestMapping("/login")
    public void login(String userName, String userPwd) throws Exception {
//        Thread.sleep(2000);
        returnBackData(userService.login(userName, userPwd));
    }


    @RequestMapping("/updateUserInfo")
        public void updateUserInfo(User user) throws Exception {
        returnBackData(userService.updateUser(user));
    }


}
