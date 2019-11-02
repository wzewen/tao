package com.java.thread.core.chapter3.A.wait_notify.a.wait_notify;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Mythread1 t1 = new Mythread1(lock);
        t1.start();
        Thread.sleep(2000);
        Mythread2 t2 = new Mythread2(lock);
        t2.start();

    }
}
