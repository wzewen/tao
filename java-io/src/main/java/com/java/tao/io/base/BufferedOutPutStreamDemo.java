package com.java.tao.io.base;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutPutStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("/Users/fish/Documents/fileOutPutStreamDemo.txt"));
        bufferedOutputStream.write("hello word!".getBytes());
        bufferedOutputStream.close();
    }
}
