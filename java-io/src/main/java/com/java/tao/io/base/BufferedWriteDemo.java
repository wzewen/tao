package com.java.tao.io.base;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/fish/Documents/write.txt"));
        writer.write("hello buffered write.");
        writer.close();
    }
}
