package com.java.thread.chapter4.A.ReentrantLock.b.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();

    public void methodA(){
        try{
            lock.lock();
            System.out.println("methodA begin, thread name:"+Thread.currentThread().getName()+", time:"+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA end, thread name:"+Thread.currentThread().getName()+", time:"+System.currentTimeMillis());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void methodB(){
        try{
            lock.lock();
            System.out.println("methodB begin, thread name:"+Thread.currentThread().getName()+", time:"+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end, thread name:"+Thread.currentThread().getName()+", time:"+System.currentTimeMillis());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
