package com.java.tao.io.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream("/Users/fish/Documents/write.txt"));
        int ch = 0;
        while ((ch=reader.read())!=-1){
            System.out.print((char)ch);
        }
        reader.close();
    }
}
