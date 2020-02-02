package com.java.tao.io.base;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name", "LiLin");
        properties.setProperty("mother", "LiLth");
        Writer writer = new FileWriter("/Users/fish/Documents/p.txt");
        properties.store(writer, "Apostle");
        writer.close();
        properties.clear();

        Reader reader = new FileReader("/Users/fish/Documents/p.txt");
        properties.load(reader);
        reader.close();
        System.out.println(properties.toString());

    }
}
