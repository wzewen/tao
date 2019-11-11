package com.java.tao.thread.core.chapter4.A.ReentrantLock.n.isLocked;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();

    public void method(){
        try {
            System.out.println("lock is occupied? --> "+lock.isLocked());
            lock.lock();
            System.out.println("lock is occupied? --> "+lock.isLocked());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
