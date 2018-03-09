package com.grass;


import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huchao on 2017/10/30.
 */
public class Test {

   @org.junit.Test
    public void test(){

       String url = "http://dev.xiaodongxing.com/api/v3/base/sendCode/?F=android&V=3.5.0&timestamp=1519796193742&sign=50a1341047a7703b80af418a317ab4a4";


       String phone = "token=2ef361611187132e10e6eccd815f9d1c&phone=13021020294&user_id=156";

       System.out.println(getMD5(phone+"appkey=hhxy@#$685&timestamp=1519796193742"));
    }

    /**
     * 功能:MD5加密
     *
     * @param s
     */
    public static String getMD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
