package com.example.collection.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64Test 编码支持
 * 1.getBytes默认 UTF 编码，base64 就可以用来将二进制文件内容编码为只包含 ascii 字符的内容。
 * 2.新的Base64API也支持URL和MINE的编码解码。
 * (Base64.getUrlEncoder()** / Base64.getUrlDecoder(), Base64.getMimeEncoder() / Base64.getMimeDecoder()**)。
 */
public class Base64Test {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        final String text = "Base64Test finally in java8 新年快乐";
        // 获取编码器
        Base64.Encoder encoder = Base64.getEncoder();
        // 获取指定字符集的字节数组
        byte[] bytes1 = text.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes2 = text.getBytes(StandardCharsets.UTF_8);
        // 执行编码
        String encodeString = encoder.encodeToString(bytes2);
        String encodeString2 = encoder.encodeToString(bytes1);

        System.out.println(encodeString);
        System.out.println(encodeString2);

        // 获取解码器
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes3 = encodeString.getBytes(StandardCharsets.UTF_8);
        byte[] bytes4 = decoder.decode(bytes3);
        System.out.println(new String(bytes4));
    }
}
