package com.util;

/**
 * String的一些封装方法
 *
 * @author szh
 * @create 2018-05-23 15:08
 **/
public class StringUtil {
    /**
     * 判断String是不是null
     * @param str
     * @return
     */
    public static boolean isNotNull(String str){
        if(str == null || str.length() ==0){
            return false;
        }
        return true;
    }
}
