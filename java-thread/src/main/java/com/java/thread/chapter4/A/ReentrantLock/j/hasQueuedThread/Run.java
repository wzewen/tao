package com.java.thread.chapter4.A.ReentrantLock.j.hasQueuedThread;

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
        Thread b = new Thread(runnable);
        b.setName("B");
        b.start();
        Thread c = new Thread();
        c.start();

        Thread.sleep(300);
        System.out.println(service.lock.hasQueuedThread(a));
        System.out.println(service.lock.hasQueuedThread(b));
        System.out.println(service.lock.hasQueuedThread(c));
        System.out.println(service.lock.hasQueuedThreads());
    }
}
