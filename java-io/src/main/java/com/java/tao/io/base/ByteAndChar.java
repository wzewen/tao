package com.java.tao.io.base;

import java.util.Arrays;

public class ByteAndChar {
    public static void main(String[] args) {
        String bytes = "abcde";
        System.out.println(Arrays.toString(bytes.getBytes()));
        String chars = "我是中国人";
        System.out.println(Arrays.toString(chars.getBytes()));
    }
}
