package com.java.thread.core.chapter4.A.ReentrantLock.l.isHeldByCurrentThread;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    public void method(){
        try {
            System.out.println("is held current lock:"+lock.isHeldByCurrentThread());
            lock.lock();
            System.out.println("is held current lock:"+lock.isHeldByCurrentThread());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
