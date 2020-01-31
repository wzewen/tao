package com.java.tao.io.base;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("/Users/fish/Downloads/SendDemo.java"));
        byte[] bytes = new byte[1024];
        int r = 0;
        while ((r = bufferedInputStream.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, r));
        }
        bufferedInputStream.close();
    }
}
