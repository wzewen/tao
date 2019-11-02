package com.java.thread.core.chapter7.A.status.a.new_runnable_terminated;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        System.out.println("main中的状态1:"+t.getState());
        Thread.sleep(1000);
        t.start();
        Thread.sleep(1000);
        System.out.println("main中的状态2:"+t.getState());
    }
}
