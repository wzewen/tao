package com.java.thread.core.chapter6.f.singleton_static_block;

public class MyObject {
    private static MyObject myObject = null;
    static {
        myObject = new MyObject();
    }
    public static MyObject getInstance(){
        return myObject;
    }
}
