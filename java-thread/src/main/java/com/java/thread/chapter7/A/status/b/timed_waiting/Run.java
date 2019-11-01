package com.java.thread.chapter7.A.status.b.timed_waiting;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(100);
        System.out.println("status --> "+t.getState());
    }
}
