package com.java.tao.io.base;

import java.io.FileInputStream;
import java.io.IOException;

public class CopyByBytes {

    public static void main(String[] args) throws IOException {
        FileInputStream read = new FileInputStream("/Users/fish/Downloads/SendDemo.java");
        byte[] bytes = new byte[128];
        int len = 0;
        while ((len = read.read(bytes))!=-1){
            System.out.print(new String(bytes, 0, len));
        }
        read.close();
    }

}
