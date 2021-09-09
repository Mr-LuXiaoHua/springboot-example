package com.dohko.example.infrastructure.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author luxiaohua
 * @create 2021-09-06 15:42
 */
public class EncryptionUtils {

    public static String base64Encode(String data) {
        return Base64.encodeBase64String(data.getBytes(StandardCharsets.UTF_8));
    }

    public static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static String md5(String data) {
        return DigestUtils.md5Hex(data);
    }

    public static String sha256Hex(String data) {
        return DigestUtils.sha256Hex(data);
    }
}
