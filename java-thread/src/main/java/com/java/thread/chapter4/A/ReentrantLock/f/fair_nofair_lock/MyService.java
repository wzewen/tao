package com.java.thread.chapter4.A.ReentrantLock.f.fair_nofair_lock;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock;
    public MyService(boolean isFair){
        this.lock = new ReentrantLock(isFair);
    }

    public void method(){
        try {
            lock.lock();
            System.out.println("thread name:"+Thread.currentThread().getName()+", 获得锁 🔒");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
