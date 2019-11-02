package com.java.thread.core.chapter4.A.ReentrantLock.f.fair_nofair_lock;

public class FairRun {

    public static void main(String[] args) {
        MyService service = new MyService(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("thread name:"+Thread.currentThread().getName()+", start ...");
                service.method();
            }
        };

        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++){
            threads[i] = new Thread(runnable);
        }

        for (Thread t : threads){
            t.start();
        }

    }
}
