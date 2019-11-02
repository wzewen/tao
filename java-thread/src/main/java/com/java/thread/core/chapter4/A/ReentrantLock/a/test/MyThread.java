package com.java.thread.core.chapter4.A.ReentrantLock.a.test;

public class MyThread extends Thread{
    private MyService service;
    public MyThread(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.method();
    }

}
