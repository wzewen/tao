package com.java.tao.thread.core.chapter7.A.status.c.blocked;

public class MyService {
    synchronized public static void method(){
        System.out.println("thread name:"+Thread.currentThread().getName()+", into method ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
