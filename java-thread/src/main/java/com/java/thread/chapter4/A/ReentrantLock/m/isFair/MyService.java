package com.java.thread.chapter4.A.ReentrantLock.m.isFair;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock;
    public MyService(boolean isFair){
        lock = new ReentrantLock(isFair);
    }

    public void method(){
        try {
            lock.lock();
            System.out.println("Thread name:"+Thread.currentThread().getName()+", Is Fair Lock? --> "+lock.isFair());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
