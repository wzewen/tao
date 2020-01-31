package com.java.tao.io.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream read = new FileInputStream("/Users/fish/Documents/Dcolor.txt");
        FileOutputStream write = new FileOutputStream("/Users/fish/Documents/CopyDcolor.txt");
        int r = 0;
        while ((r = read.read())!=-1){
            write.write(r);
        }
        read.close();
        write.close();
    }

}
