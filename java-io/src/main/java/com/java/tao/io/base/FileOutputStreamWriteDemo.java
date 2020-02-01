package com.java.tao.io.base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileOutputStreamWriteDemo {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream("/Users/fish/Documents/write.txt"));
        writer.write("世界");
        writer.close();
    }
}
