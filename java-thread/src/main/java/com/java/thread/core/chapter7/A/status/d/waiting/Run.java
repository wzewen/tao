package com.java.thread.core.chapter7.A.status.d.waiting;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(100);
        System.out.println("t status --> "+t.getState());
    }
}
