package com.java.tao.thread.core.chapter3.A.wait_notify.a.wait_notify;

public class Mythread2 extends Thread {
    private Object lock;
    public Mythread2(Object lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        try {
            synchronized (lock){
                System.out.println("start notify time : "+System.currentTimeMillis());
                lock.notify();
                System.out.println("end   notify time : "+System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
