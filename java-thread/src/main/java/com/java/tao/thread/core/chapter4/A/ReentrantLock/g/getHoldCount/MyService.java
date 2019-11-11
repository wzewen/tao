package com.java.tao.thread.core.chapter4.A.ReentrantLock.g.getHoldCount;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();

    public void method1(){
        try {
            lock.lock();
            System.out.println("method1 getHoldCount="+lock.getHoldCount());
            method2();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void method2() {
        try {
            lock.lock();
            System.out.println("method2 getHoldCount="+lock.getHoldCount());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
