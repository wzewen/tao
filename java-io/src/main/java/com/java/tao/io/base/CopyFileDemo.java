package com.java.tao.io.base;

import java.io.*;

public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/fish/Documents/2019-10-14任务aoiid查询.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/fish/Documents/copy-2019-10-14任务aoiid查询.txt"));
        String line = null;
        while ((line=reader.readLine())!=null){
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }

}
