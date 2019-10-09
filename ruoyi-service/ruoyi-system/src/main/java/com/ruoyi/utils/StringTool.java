package com.ruoyi.utils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringTool {

    public static String mySort(String source) {
        char[] c = source.toCharArray();//将字符串转换成char数组
        Arrays.sort(c);//对数组进行排序
        return String.valueOf(c);//返回数组。注：char数组相当于String类型
    } //完成后直接调用该方法就好了：

    /**
     * 字母排序
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static  <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();

        map.entrySet().stream()
                .sorted(Map.Entry.<K, V>comparingByValue()
                        .reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }


   public static void main(String[] args) {
        String result = mySort("SECRIA");
        System.out.println(result);
    }
}

