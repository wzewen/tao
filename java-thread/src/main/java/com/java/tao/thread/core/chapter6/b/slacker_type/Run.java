package com.java.tao.thread.core.chapter6.b.slacker_type;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t.start();
        t2.start();
        Thread.sleep(1000);
        t3.start();
    }
}
