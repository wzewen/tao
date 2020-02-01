package com.java.tao.io.base;

import java.io.*;

public class CopyAllFromDir {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("/Users/fish/Documents/Ali-Java");
        File amiFile = new File("/Users/fish/Documents/Ali-Java-test");
        if(!amiFile.exists()){
            amiFile.mkdir();
        }
        File[] files = srcFile.listFiles();
        for (File file : files){
            File newFile = new File(amiFile, file.getName());
            copyFile(file, newFile);
        }
    }

    private static void copyFile(File file, File newFile) throws IOException {
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(newFile));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = reader.read(bytes))!=-1){
            writer.write(bytes, 0, len);
        }
        writer.close();
        reader.close();
    }
}
