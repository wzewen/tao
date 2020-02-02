package com.java.tao.io.base;

import com.java.tao.io.bean.Person;

import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("zhangsan", 12);
        write(person);
        read();
    }

    private static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/Users/fish/Documents/person.txt"));
        Object object = inputStream.readObject();
        inputStream.close();
        System.out.println(object);
    }

    private static void write(Person person) throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/Users/fish/Documents/person.txt"));
        outputStream.writeObject(person);
        outputStream.close();
    }
}
