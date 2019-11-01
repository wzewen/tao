package com.java.thread.chapter6.f.singleton_static_block;

public class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println(MyObject.getInstance().hashCode());
    }
}
