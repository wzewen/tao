package com.java.tao.thread.core.chapter4.B.ReentrantReadWriteLock.c.read_write_lock;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThreadA a = new MyThreadA(service);
        a.setName("A");
        a.start();
        Thread.sleep(300);
        MyThreadB b = new MyThreadB(service);
        b.setName("B");
        b.start();
    }
}
