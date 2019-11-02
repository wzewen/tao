package com.java.thread.core.chapter4.A.ReentrantLock.r.awaitUninterruptibly;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        final MyService service = new MyService();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.method();
            }
        };

        Thread t = new Thread(runnable);
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }
}
