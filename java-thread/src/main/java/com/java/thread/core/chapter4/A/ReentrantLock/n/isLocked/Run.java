package com.java.thread.core.chapter4.A.ReentrantLock.n.isLocked;

public class Run {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                MyService service = new MyService();
                service.method();
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }
}
