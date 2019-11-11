package com.java.tao.thread.core.chapter4.A.ReentrantLock.q.tryLock_timeout;

public class Run {

    public static void main(String[] args) {
        final MyService service = new MyService();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("thread name:"+Thread.currentThread().getName()+" run time:"+System.currentTimeMillis());
                service.method();
            }
        };

        Thread a = new Thread(runnable);
        a.setName("A");
        a.start();
        Thread b = new Thread(runnable);
        b.setName("B");
        b.start();
    }
}
