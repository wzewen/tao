package com.java.tao.thread.core.chapter7.A.status.c.blocked;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread1 t1 = new MyThread1();
        t1.setName("T1");
        t1.start();
        Thread.sleep(100);
        MyThread2 t2 = new MyThread2();
        t2.setName("T2");
        t2.start();
        System.out.println("thread t2 status --> "+t2.getState());
    }
}
