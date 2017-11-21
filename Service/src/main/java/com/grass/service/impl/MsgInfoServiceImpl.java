package com.grass.service.impl;

import com.grass.entity.ImagesInfo;
import com.grass.entity.MsgInfo;
import com.grass.entity.vo.MsgInfoVo;
import com.grass.exception.BusinessException;
import com.grass.mapper.MsgInfoMapper;
import com.grass.mapper.UserMapper;
import com.grass.service.MsgInfoService;
import com.grass.utils.PropertyUtil;
import com.grass.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
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
        List<MsgInfoVo> msgs = msgInfoMapper.findMsg(userId, pageIndex, pageSize);
        for (MsgInfoVo msg : msgs) {
            List<ImagesInfo> imagesInfos = new ArrayList<>();
            if(!Tools.getStringIsNull(msg.getMsgImages())){
                for (String path : msg.getMsgImages().split("\\|")) {
                    ImagesInfo info = new ImagesInfo();
                    //生成原始图片地址
                    info.setImageUrl(PropertyUtil.getProperty("serviceUrl") + PropertyUtil.getProperty("uploadPath")
                            + "/"+ path);
                    //生成缩略图地址
                    info.setImagemThumbnailUrl(PropertyUtil.getProperty("serviceUrl") + PropertyUtil.getProperty("uploadPath")
                            +"/" + PropertyUtil.getProperty("thumbnailPath") + "/" + path);
                    imagesInfos.add(info);
                }
            }
            msg.setImagesInfo(imagesInfos);
            //原始字段置空
            msg.setMsgImages("");
        }
        return msgs;
    }

    @Override
    public void saveMsg(MsgInfo msgInfo) {
        if (userMapper.findUserById(msgInfo.getUserId()) == null) {
            throw new BusinessException("EG-M-001");
        }
        if(Tools.getStringIsNull(msgInfo.getMsgContent()) && Tools.getStringIsNull(msgInfo.getMsgImages())){
            throw new BusinessException("EG-M-002");
        }
        //设置成当前时间
        msgInfo.setCreateTime(new Date());
        msgInfoMapper.saveMsg(msgInfo);
    }
}
