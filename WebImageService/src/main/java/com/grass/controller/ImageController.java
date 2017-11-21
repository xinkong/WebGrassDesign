package com.grass.controller;

import com.grass.entity.ImagesInfo;
import com.grass.service.ImagesInfoServer;
import com.grass.utils.DataFormat;
import com.grass.utils.PropertyUtil;
import com.grass.utils.Tools;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by huchao on 2017/10/30.
 */
@RequestMapping("/fileUpload")
@Controller
public class ImageController extends BaseController {

    @Autowired
    private ImagesInfoServer imagesInfoServer;

    /*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("/upload")
    public void springUpload(HttpServletRequest request) throws Exception {
        String imageUrls = "";
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = imagesInfoServer.saveImageInfo(file.getOriginalFilename());
                    imageUrls = imageUrls + path + "|";

                    //获取磁盘路径
                    ServletContext sc = request.getSession().getServletContext();
                    // 上传位置
                    String uploadPath = sc.getRealPath(File.separator+ PropertyUtil.getProperty("uploadPath")) + File.separator; // 设定文件保存的目录
                    File f = new File(uploadPath);
                    if (!f.exists())
                        f.mkdirs();
                    file.transferTo(new File(uploadPath + path));
                    //生成对应的缩略图
                    String thumbnailPath = uploadPath + PropertyUtil.getProperty("thumbnailPath") + File.separator;
                    File thumbanilFile = new File(thumbnailPath);
                    if(!thumbanilFile.exists()){
                        thumbanilFile.mkdirs();
                    }
                    Thumbnails.of(uploadPath + path)
                            .size(300, 300)
                            .toFile(thumbnailPath+path);
                }
            }
        }

        if (!Tools.getStringIsNull(imageUrls)) {
            imageUrls = imageUrls.substring(0, imageUrls.length() - 1);
        }

        returnBackData(imageUrls);
    }
}
