package com.java.thread.chapter4.B.ReentrantReadWriteLock.b.write_write_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void method(){
        try {
            lock.writeLock().lock();
            System.out.println("thread name:"+Thread.currentThread().getName()+", get write lock time:"+System.currentTimeMillis());
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("thread name:"+Thread.currentThread().getName()+", release write lock time:"+System.currentTimeMillis());
            lock.writeLock().unlock();
        }
    }
}
