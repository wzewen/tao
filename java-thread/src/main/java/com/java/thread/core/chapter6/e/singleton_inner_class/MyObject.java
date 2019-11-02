package com.java.thread.core.chapter6.e.singleton_inner_class;

public class MyObject {
    private MyObject(){

    }

    private static class MyObjectHandler{
        private static MyObject myObject = new MyObject();
    }

    public static MyObject getInstance(){
        return MyObjectHandler.myObject;
    }
}
