package com.java.thread.core.chapter4.A.ReentrantLock.q.tryLock_timeout;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();

    public void method(){
        try {
            if(lock.tryLock(3, TimeUnit.SECONDS)){
                System.out.println("thread name:"+Thread.currentThread().getName()+", get lock time:"+System.currentTimeMillis());
                Thread.sleep(10000);
            }else{
                System.out.println("thread name:"+Thread.currentThread().getName()+", not get lock.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

}
