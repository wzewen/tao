package com.java.thread.chapter6.c.slacker_synchronized_method;

public class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println(MyObject.getInstance().hashCode());
    }
}
