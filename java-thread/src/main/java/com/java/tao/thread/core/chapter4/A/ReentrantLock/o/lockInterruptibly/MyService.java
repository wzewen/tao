package com.java.tao.thread.core.chapter4.A.ReentrantLock.o.lockInterruptibly;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();

    public void method(){
        try {
            lock.lockInterruptibly();
            System.out.println("lock begin, thread name:"+Thread.currentThread().getName());
            for (int i=0; i<Integer.MAX_VALUE/10; i++){
                Math.random();
            }
            System.out.println("lock end, thread name:"+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread())
            lock.unlock();
        }
    }
}
