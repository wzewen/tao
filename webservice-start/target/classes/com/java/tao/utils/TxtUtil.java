package com.java.tao.utils;

import java.io.File;
import java.io.FileOutputStream;

public class TxtUtil {

    public static void write(String str){
        FileOutputStream fileOutputStream = null;
        File file = new File("/Users/fish/Documents/平安银行评分数据.csv");
        try {
            if(file.exists()){
                //判断文件是否存在，如果不存在就新建一个txt
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(str.getBytes());
            //换行
            fileOutputStream.write("\r\n".getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String str = "\"指数\",\"招商\",\"北京\"";
        write(str);
        String str2 = "\"结果\",\"1\",\"2\"";
        write(str2);
    }
}
