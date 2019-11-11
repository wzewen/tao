package com.java.tao.thread.core.chapter6.e.singleton_inner_class;

public class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println(MyObject.getInstance().hashCode());
    }
}
