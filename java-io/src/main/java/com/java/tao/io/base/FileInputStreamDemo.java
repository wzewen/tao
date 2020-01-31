package com.java.tao.io.base;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("/Users/fish/Documents/fileOutPutStreamDemo.txt");
        int read = 0;
        while ((read=stream.read())!=-1){
            System.out.print((char)read);
        }
        stream.close();
    }
}
