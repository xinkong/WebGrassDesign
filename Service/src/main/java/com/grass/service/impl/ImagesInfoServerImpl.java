package com.grass.service.impl;

import com.grass.entity.ImagesInfo;
import com.grass.mapper.ImagesInfoMapper;
import com.grass.service.ImagesInfoServer;
import com.grass.utils.DataFormat;
import com.grass.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by huchao on 2017/10/30.
 */
@Service
public class ImagesInfoServerImpl implements ImagesInfoServer {

    @Autowired
    private ImagesInfoMapper imagesInfoMapper;

    @Override
    public String saveImageInfo(ImagesInfo info) {
        //生成图片ID
        String imageUrl = DataFormat.createUUID();
        imageUrl = imageUrl + info.getImageUrl().substring(info.getImageUrl().lastIndexOf("."));
        info.setImageUrl(imageUrl);
        imagesInfoMapper.saveImageInfo(info);

        return imageUrl;
    }
}
