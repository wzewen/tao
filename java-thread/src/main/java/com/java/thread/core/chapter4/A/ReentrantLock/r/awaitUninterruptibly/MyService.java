package com.java.thread.core.chapter4.A.ReentrantLock.r.awaitUninterruptibly;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void method(){
        try {
            lock.lock();
            System.out.println("wait begin");
            condition.awaitUninterruptibly();
            System.out.println("wait end");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("catch");
        }finally {
            lock.unlock();
        }
    }
}
