package com.java.thread.chapter6.d.slacker_synchronized_dcl;

public class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println(MyObject.getInstance().hashCode());
    }
}
