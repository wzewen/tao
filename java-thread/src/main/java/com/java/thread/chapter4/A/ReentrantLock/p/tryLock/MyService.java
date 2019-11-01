package com.java.thread.chapter4.A.ReentrantLock.p.tryLock;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();

    public void method(){
        try {
            if(lock.tryLock()){
                System.out.println("thread name:"+Thread.currentThread().getName()+", get lock.");
            }else{
                System.out.println("thread name:"+Thread.currentThread().getName()+", not get lock.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
