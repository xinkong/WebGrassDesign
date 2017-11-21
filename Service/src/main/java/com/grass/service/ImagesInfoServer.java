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
     * @param originalPath 原始文件路径,获取文件名称
     */
    String saveImageInfo(String originalPath);

}
