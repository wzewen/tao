package com.java.thread.chapter4.B.ReentrantReadWriteLock.c.read_write_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        try {
            lock.readLock().lock();
            System.out.println("thread name:"+Thread.currentThread().getName()+", get read lock time:"+System.currentTimeMillis());
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("thread name:"+Thread.currentThread().getName()+", release read lock time:"+System.currentTimeMillis());
            lock.readLock().unlock();
        }
    }

    public void write(){
        try {
            lock.writeLock().lock();
            System.out.println("thread name:"+Thread.currentThread().getName()+", get write lock time:"+System.currentTimeMillis());
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("thread name:"+Thread.currentThread().getName()+", release write lock time:"+System.currentTimeMillis());
            lock.writeLock().unlock();
        }
    }
}
