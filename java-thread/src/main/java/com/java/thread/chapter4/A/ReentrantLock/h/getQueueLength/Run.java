package com.java.thread.chapter4.A.ReentrantLock.h.getQueueLength;

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
        Thread.sleep(300);
        System.out.println("have "+service.lock.getQueueLength()+" thread waiting ...");
    }

}
