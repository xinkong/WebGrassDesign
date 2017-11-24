package com.grass.service.impl;

import com.grass.exception.BusinessException;
import com.grass.service.ImagesInfoServer;
import com.grass.utils.DataFormat;
import org.springframework.stereotype.Service;

/**
 * Created by huchao on 2017/10/30.
 */
@Service
public class ImagesInfoServerImpl implements ImagesInfoServer {


    @Override
    public String saveImageInfo(String originalPath) {
        //生成图片ID
        String imageUrl = DataFormat.createUUID();
        imageUrl = imageUrl + originalPath.substring(originalPath.lastIndexOf("."));
//        info.setImageUrl(imageUrl);
//        imagesInfoMapper.saveImageInfo(info);
        //判断是否是jpg,png,gif 否者报错
        if(!imageUrl.endsWith("jpg") && !imageUrl.endsWith("png") && !imageUrl.endsWith("gif")){
            throw new BusinessException("EG-M-003");
        }
        return imageUrl;
    }
}
