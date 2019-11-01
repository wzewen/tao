package com.java.thread.chapter4.A.ReentrantLock.m.isFair;

public class Run {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                MyService service = new MyService(true);
                service.method();
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                MyService service = new MyService(false);
                service.method();
            }
        };
        Thread a = new Thread(runnable);
        a.setName("A");
        a.start();
        Thread b = new Thread(runnable2);
        b.setName("B");
        b.start();

    }
}
