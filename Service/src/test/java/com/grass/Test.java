package com.grass;

/**
 * Created by huchao on 2017/10/30.
 */
public class Test {

    @org.junit.Test
    public void test(){
        String path = "adfadsf.adf";
        System.out.println(path.substring(path.lastIndexOf(".")));
    }

}
