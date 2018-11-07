package com.grass;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by huchao on 2017/10/30.
 */
public class Test {

    @org.junit.Test
    public void test() {
        String input = "12345678909tt23412345677909y";
        List<String> phoneNums = new ArrayList<>();
        //判断当前字符串是否大于11位
        int firstNumAppear = input.indexOf("1");
        boolean is1FirstNum = false;
        for (int i = 0; i < input.length(); i++) {
            //获得第i个字符
            String value = input.substring(i, i + 1);
            //出现数字
            if (isInteger(value)) {
                //判断是不是1
                if ("1".equals(value) && firstNumAppear == 0 && !is1FirstNum) {
                    is1FirstNum = true;
                    firstNumAppear++;
                } else {
                    if (firstNumAppear != 0) {
                        firstNumAppear++;
                    }
                }
                if (firstNumAppear == 11) {
                    firstNumAppear = 0;
                    String nums = input.substring(i - 10, i + 1);
                    if (!phoneNums.contains(nums)) {
                        System.out.println("连续出现 11个数字");
                        phoneNums.add(nums);
                    }
                }
            } else {
                firstNumAppear = 0;
                is1FirstNum = false;
            }
        }
        System.out.println(firstNumAppear + phoneNums.toString());
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
