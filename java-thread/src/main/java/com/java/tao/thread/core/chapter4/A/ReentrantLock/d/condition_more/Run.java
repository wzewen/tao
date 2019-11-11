package com.java.tao.thread.core.chapter4.A.ReentrantLock.d.condition_more;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThreadA a = new MyThreadA(service);
        a.start();
        MyThreadB b = new MyThreadB(service);
        b.start();
        Thread.sleep(3000);
        service.signalA();
    }

}
