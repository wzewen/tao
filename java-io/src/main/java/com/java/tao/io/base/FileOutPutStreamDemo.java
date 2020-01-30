package com.java.tao.io.base;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStreamDemo {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/fish/Documents/fileOutPutStreamDemo.txt", true);
        fileOutputStream.write("hello io!".getBytes());
        fileOutputStream.close();
    }
}
