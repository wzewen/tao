package com.java.thread.chapter4.B.ReentrantReadWriteLock.a.read_read_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void method(){
        try {
            lock.readLock().lock();
            System.out.println("thread name:"+Thread.currentThread().getName()+", get lock time:"+System.currentTimeMillis());
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("thread name:"+Thread.currentThread().getName()+", release lock time:"+System.currentTimeMillis());
            lock.readLock().unlock();
        }
    }
}
