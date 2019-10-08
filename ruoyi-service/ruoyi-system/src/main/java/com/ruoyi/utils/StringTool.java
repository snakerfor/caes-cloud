package com.ruoyi.utils;

import java.util.Arrays;

public class StringTool {

    public static String mySort(String source) {
        char[] c = source.toCharArray();//将字符串转换成char数组
        Arrays.sort(c);//对数组进行排序
        return String.valueOf(c);//返回数组。注：char数组相当于String类型
    } //完成后直接调用该方法就好了：

   public static void main(String[] args) {
        String result = mySort("SECRIA");
        System.out.println(result);
    }
}

