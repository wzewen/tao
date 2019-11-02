package com.java.thread.core.chapter3.A.wait_notify.b.wait_notiry_2;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThreadA a = new MyThreadA(lock);
        a.start();
        Thread.sleep(1000);
        MyThreadB b = new MyThreadB(lock);
        b.start();

    }
}
