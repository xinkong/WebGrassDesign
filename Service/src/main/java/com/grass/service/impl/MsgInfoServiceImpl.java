package com.grass.service.impl;

import com.grass.entity.MsgInfo;
import com.grass.entity.vo.MsgInfoVo;
import com.grass.exception.BusinessException;
import com.grass.mapper.MsgInfoMapper;
import com.grass.mapper.UserMapper;
import com.grass.service.MsgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by huchao on 2017/11/1.
 */
@Service
public class MsgInfoServiceImpl implements MsgInfoService {

    @Autowired
    private MsgInfoMapper msgInfoMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<MsgInfoVo> findMsgInfo(Integer userId, int pageIndex, int pageSize) {
        return msgInfoMapper.findMsg(userId,pageIndex,pageSize);
    }

    @Override
    public void saveMsg(MsgInfo msgInfo) {
        if(userMapper.findUserById(msgInfo.getUserId()) == null){
            throw new BusinessException("EG-M-001");
        }
        //设置成当前时间
        msgInfo.setCreateTime(new Date());
        msgInfoMapper.saveMsg(msgInfo);
    }
}
