package com.java.thread.chapter4.A.ReentrantLock.e.condition_producer_consumer;

public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();
        MyThreadA a = new MyThreadA(service);
        MyThreadB b = new MyThreadB(service);

        a.start();
        b.start();
    }
}
