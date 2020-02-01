package com.java.tao.io.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/fish/Documents/write.txt"));
        String line = null;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
        reader.close();
    }
}
