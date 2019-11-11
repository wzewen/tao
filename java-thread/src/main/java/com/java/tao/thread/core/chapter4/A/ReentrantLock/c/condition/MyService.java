package com.java.tao.thread.core.chapter4.A.ReentrantLock.c.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod(){
        try{
            lock.lock();
            System.out.println("wait time:"+System.currentTimeMillis());
            condition.await();
            System.out.println("notify time:"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalMethod(){
        try{
            lock.lock();
            System.out.println("signal time:"+System.currentTimeMillis());
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
