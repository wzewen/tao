package com.java.thread.core.chapter7.A.status.d.waiting;

public class MyThread extends Thread {

    @Override
    public void run(){
        synchronized (Lock.lock){
            try {
                Lock.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
