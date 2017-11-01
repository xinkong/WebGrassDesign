package com.grass.service;

import com.grass.entity.MsgInfo;
import com.grass.entity.vo.MsgInfoVo;

import java.util.List;

/**
 * Created by huchao on 2017/11/1.
 */
public interface MsgInfoService {

    /**
     * 查找消息
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<MsgInfoVo> findMsgInfo(Integer userId, int pageIndex, int pageSize);

    /**
     * 保存消息
     * @param msgInfo
     */
    void saveMsg(MsgInfo msgInfo);
}
