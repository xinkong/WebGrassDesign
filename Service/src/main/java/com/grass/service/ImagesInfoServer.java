package com.grass.service;

import com.grass.entity.ImagesInfo;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by huchao on 2017/10/30.
 */
public interface ImagesInfoServer {

    /**
     * 保存图片信息
     * @param info
     */
    String saveImageInfo(ImagesInfo info);

}
