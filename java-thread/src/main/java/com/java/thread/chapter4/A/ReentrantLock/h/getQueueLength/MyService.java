package com.java.thread.chapter4.A.ReentrantLock.h.getQueueLength;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    public ReentrantLock lock = new ReentrantLock();

    public void method(){
        try {
            lock.lock();
            System.out.println("thread name:"+Thread.currentThread().getName()+", into ...");
            Thread.sleep(Integer.MAX_VALUE);
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

}
