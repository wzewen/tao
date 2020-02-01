package com.java.tao.io.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/fish/Documents/write.txt"));
//        int r = 0;
//        while((r=reader.read()) != -1){
//            System.out.print((char)r);
//        }
        char[] chars = new char[1024];
        int len = 0;
        while ((len=reader.read(chars))!=-1){
            System.out.print(new String(chars, 0, len));
        }
        reader.close();
    }
}
