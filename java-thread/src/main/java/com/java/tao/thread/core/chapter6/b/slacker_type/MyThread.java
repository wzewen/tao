package com.java.tao.thread.core.chapter6.b.slacker_type;

public class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println(MyObject.getInstance().hashCode());
    }
}
