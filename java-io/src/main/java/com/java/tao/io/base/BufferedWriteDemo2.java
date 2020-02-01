package com.java.tao.io.base;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteDemo2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/fish/Documents/write2.txt"));
        writer.write("hello word!");
        writer.newLine();
        writer.write("hello java!");
        writer.flush();
        writer.close();
    }
}
