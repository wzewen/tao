package com.java.thread.core.chapter4.A.ReentrantLock.d.condition_more;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA(){
        try {
            lock.lock();
            System.out.println("begin a, time:"+System.currentTimeMillis());
            conditionA.await();
            System.out.println("end a, time:"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            System.out.println("begin b, time:"+System.currentTimeMillis());
            conditionB.await();
            System.out.println("end b, time:"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalA(){
        try {
            lock.lock();
            System.out.println("signal a, time:"+System.currentTimeMillis());
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalB(){
        try {
            lock.lock();
            System.out.println("signal b, time:"+System.currentTimeMillis());
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
