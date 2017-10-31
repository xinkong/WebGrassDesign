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