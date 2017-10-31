package com.grass.utils;

import java.util.UUID;

/**
 * Created by huchao on 2017/10/30.
 * 数据转换
 */
public class DataFormat {

    /**
     * 生成UUID唯一id
     * @return
     */
    public static String createUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
