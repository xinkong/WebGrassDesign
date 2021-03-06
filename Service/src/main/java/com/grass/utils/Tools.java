package com.grass.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class Tools {

    /**
     * 判断字符串是不是null或者""
     *
     * @param s
     * @return
     */
    public static boolean getStringIsNull(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        return false;
    }

    /**
     * 获得上传文件路径
     * @return
     */
    public static String getUploadFilePath(){
        return PropertyUtil.getProperty("serviceUrl") + PropertyUtil.getProperty("uploadPath")
                + "/";
    }
    /**
     * 获得上传文件缓存路径
     * @return
     */
    public static String getUploadFileThumbnailPath(){
        return PropertyUtil.getProperty("serviceUrl") + PropertyUtil.getProperty("uploadPath")
                +"/" + PropertyUtil.getProperty("thumbnailPath") + "/";
    }


    public static String objToStr(String s) {
        if (getStringIsNull(s)) {
            return "";
        }
        return s.trim();
    }


    public static String getLoginToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (request != null) {
            String token = request.getParameter("token");
                return token;
        }

        return null;
    }


}