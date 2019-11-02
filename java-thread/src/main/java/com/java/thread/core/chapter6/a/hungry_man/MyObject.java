package com.java.thread.core.chapter6.a.hungry_man;

public class MyObject {
    private static MyObject myObject = new MyObject();
    private MyObject(){

    }
    public static MyObject getInstance(){
        /**
         * 此版本代码为立即加载
         * 此版本代码的缺点是不能有其他实例变量
         * 因为getInstance()方法没有同步
         * 所以有可能出现非线程安全问题
         */
        return myObject;
    }
}
