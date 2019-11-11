package com.java.tao.thread.core.chapter4.A.ReentrantLock.b.test;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThreadA a = new MyThreadA(service);
        a.setName("A");
        a.start();
        System.out.println("a start ...");
        MyThreadAA aa = new MyThreadAA(service);
        aa.setName("AA");
        aa.start();
        System.out.println("aa start ...");
        Thread.sleep(100);
        MyThreadB b = new MyThreadB(service);
        b.setName("B");
        b.start();
        System.out.println("b start ...");
        MyThreadBB bb = new MyThreadBB(service);
        bb.setName("BB");
        bb.start();
        System.out.println("bb start ...");
        System.out.println();
    }

}
