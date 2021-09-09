package com.dohko.example.infrastructure.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author luxiaohua
 * @create 2021-09-06 15:34
 */
public class StrUtils {

    /**
     * 生成随机字符串
     * @param len 字符串长度
     * @return
     */
    public static String randomStr(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }

    public static void main(String[] args) {
        System.out.println(randomStr(6));
    }
}
