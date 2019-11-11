package com.java.tao.thread.core.chapter4.A.ReentrantLock.k.hasWaiters;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        final MyService service = new MyService();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.method();
            }
        };

        Thread[] threads = new Thread[10];
        for (int i=0; i<10; i++){
            threads[i] = new Thread(runnable);
        }
        for (Thread t : threads){
            t.start();
        }

        Thread.sleep(500);
        service.signal();
    }

}
