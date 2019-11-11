package com.java.tao.thread.core.chapter4.A.ReentrantLock.a.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();

    public void method(){
        lock.lock();
        for(int i=0;i<50;i++){
            System.out.println("Thread name:"+Thread.currentThread().getName()+", i="+i);
        }
        lock.unlock();
    }

}
