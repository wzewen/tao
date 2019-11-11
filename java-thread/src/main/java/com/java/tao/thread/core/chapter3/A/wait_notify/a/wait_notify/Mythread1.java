package com.java.tao.thread.core.chapter3.A.wait_notify.a.wait_notify;

public class Mythread1 extends Thread {
    private Object lock;
    public Mythread1(Object obj){
        this.lock = obj;
    }

    @Override
    public void run(){
        try {
            synchronized (lock){
                System.out.println("start wait time : "+System.currentTimeMillis());
                lock.wait();
                System.out.println("end   wait time : "+System.currentTimeMillis());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
