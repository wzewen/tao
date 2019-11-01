package com.java.thread.chapter4.A.ReentrantLock.o.lockInterruptibly;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        final MyService service = new MyService();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.method();
            }
        };
        Thread a = new Thread(runnable);
        a.setName("A");
        a.start();
        Thread.sleep(500);
        Thread b = new Thread(runnable);
        b.setName("B");
        b.start();
        b.interrupt();
        System.out.println("main end.");
    }
}
