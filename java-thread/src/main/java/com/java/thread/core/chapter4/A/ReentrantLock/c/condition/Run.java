package com.java.thread.core.chapter4.A.ReentrantLock.c.condition;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThread t = new MyThread(service);
        t.start();
        Thread.sleep(3000);
        service.signalMethod();
    }

}
