package com.java.tao.io.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImageDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream read = new FileInputStream("/Users/fish/Downloads/6b13c527e84b875f28f06ae1cec811d7.jpg");
        FileOutputStream write = new FileOutputStream("/Users/fish/Downloads/demo.jpg");
        int r = 0;
        while ((r = read.read()) != -1){
            write.write(r);
        }
        read.close();
        write.close();
    }
}
