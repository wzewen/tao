package com.java.thread.chapter4.A.ReentrantLock.k.hasWaiters;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    public ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void method(){
        try {
            lock.lock();
            System.out.println("thread name:"+Thread.currentThread().getName()+" awaiting ...");
            condition.await();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal(){
        try {
            lock.lock();
            System.out.println("have awaiting thread? -->"+lock.hasWaiters(condition)+", awaiting threads="+lock.getWaitQueueLength(condition));
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
