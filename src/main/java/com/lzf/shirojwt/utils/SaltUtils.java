package com.lzf.shirojwt.utils;

import java.util.Random;

/**
 * @author zongfang
 * @date 2022/4/18
 */
public class SaltUtils {
    public static String getSalt(int n){
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/*-+!@#$%^&*()".toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<n;i++){
            char aChar = chars[new Random().nextInt(chars.length)];
            stringBuilder.append(aChar);
        }
        return stringBuilder.toString();
    }
}
