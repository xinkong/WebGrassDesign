package com.grass.controller;

import com.grass.entity.ImagesInfo;
import com.grass.service.ImagesInfoServer;
import com.grass.utils.DataFormat;
import com.grass.utils.Tools;
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
@RequestMapping("/uploadImages")
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
                    BufferedImage image = ImageIO.read(file.getInputStream());
                    String path = imagesInfoServer.saveImageInfo(new ImagesInfo(file.getOriginalFilename(), image.getWidth(), image.getHeight(), file.getSize()));
//                    String path = DataFormat.createUUID()+file.getOriginalFilename();
                    imageUrls = imageUrls + path + "|";

                    //获取磁盘路径
                    ServletContext sc = request.getSession().getServletContext();
                    // 上传位置
                    String uploadPath = sc.getRealPath("/upload") + "/"; // 设定文件保存的目录
                    File f = new File(uploadPath);
                    if (!f.exists())
                        f.mkdirs();
                    file.transferTo(new File(uploadPath + path));
                }
            }
        }

        if (!Tools.getStringIsNull(imageUrls)) {
            imageUrls = imageUrls.substring(0, imageUrls.length() - 1);
        }

        returnBackData(imageUrls);
    }


    /**
     * 一次上传多张图片
     */
    @RequestMapping("/threeFile")
    public void threeFileUpload(@RequestParam("file") CommonsMultipartFile files[], HttpServletRequest request) throws Exception {

        List<String> list = new ArrayList<String>();
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();

        for (int i = 0; i < files.length; i++) {
            // 获得原始文件名
            String fileName = files[i].getOriginalFilename();
            System.out.println("原始文件名:" + fileName);
            // 新文件名
            String newFileName = UUID.randomUUID() + fileName;
            if (!files[i].isEmpty()) {
                try {
                    FileOutputStream fos = new FileOutputStream(path
                            + newFileName);
                    InputStream in = files[i].getInputStream();
                    int b = 0;
                    while ((b = in.read()) != -1) {
                        fos.write(b);
                    }
                    fos.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("上传图片到:" + path + newFileName);
            list.add(path + newFileName);

        }
        returnBackData(list);
    }


}
