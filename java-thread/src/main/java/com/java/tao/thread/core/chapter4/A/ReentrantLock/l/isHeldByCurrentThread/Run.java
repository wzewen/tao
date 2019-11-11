package com.java.tao.thread.core.chapter4.A.ReentrantLock.l.isHeldByCurrentThread;

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
