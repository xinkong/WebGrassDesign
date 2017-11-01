package com.grass.mapper;

import com.grass.entity.MsgInfo;
import com.grass.entity.vo.MsgInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huchao on 2017/11/1.
 */
public interface MsgInfoMapper {

    /**
     * 查找消息
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<MsgInfoVo> findMsg(@Param("userId") int userId, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    /**
     * 保存消息
     * @param msgInfo
     */
    void saveMsg(MsgInfo msgInfo);
}
