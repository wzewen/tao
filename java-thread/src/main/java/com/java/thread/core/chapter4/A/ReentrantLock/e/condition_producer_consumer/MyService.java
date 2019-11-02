package com.java.thread.core.chapter4.A.ReentrantLock.e.condition_producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValut = false;

    public void set(){
        try {
            lock.lock();
            if(hasValut==true){
                condition.await();
            }
            System.out.println("生产 🌟");
            hasValut = true;
            condition.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            if(hasValut==false){
                condition.await();
            }
            System.out.println("消费 ⭐️");
            hasValut=false;
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
