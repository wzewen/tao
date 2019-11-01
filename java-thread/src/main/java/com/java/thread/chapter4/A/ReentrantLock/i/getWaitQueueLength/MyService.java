package com.java.thread.chapter4.A.ReentrantLock.i.getWaitQueueLength;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    public ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void methodAwait(){
        try{
            lock.lock();
            condition.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void methodSignal(){
        try {
            lock.lock();
            System.out.println("have "+lock.getWaitQueueLength(condition)+" thread awaiting ...");
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
