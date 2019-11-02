package com.java.thread.core.chapter3.A.wait_notify.b.wait_notiry_2;

public class MyThreadA extends Thread {
    private Object lock = new Object();
    public MyThreadA(Object lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        try {
            synchronized (lock){
                if(MyList.size()!=5){
                    System.out.println("wait begin : "+System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end   : "+System.currentTimeMillis());
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
