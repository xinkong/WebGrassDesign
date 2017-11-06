package com.grass.controller;

import com.grass.entity.MsgInfo;
import com.grass.service.MsgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huchao on 2017/11/1.
 */
@Controller
@RequestMapping("/msgInfo")
public class MsgInfoController extends BaseController{

    @Autowired
    private MsgInfoService msgInfoService;

    @RequestMapping("/findMsg")
    public void findMsgInfo(int pageIndex,int pageSize) throws Exception{
        returnBackData(msgInfoService.findMsgInfo(0,pageIndex,pageSize));
    }

    /**
     * 保存消息
     * @param info
     * @throws Exception
     */
    @RequestMapping(value = "/saveMsg" ,method = RequestMethod.POST)
    public void saveMsg(@RequestBody MsgInfo info) throws Exception{
        msgInfoService.saveMsg(info);
        returnBackData("发送成功");
    }

}
