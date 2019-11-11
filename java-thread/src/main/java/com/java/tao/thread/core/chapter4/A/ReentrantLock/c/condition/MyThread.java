package com.java.tao.thread.core.chapter4.A.ReentrantLock.c.condition;

public class MyThread extends Thread{
    private MyService service;
    public MyThread(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.waitMethod();
    }

}
