package com.java.thread.chapter4.A.ReentrantLock.b.test;

public class MyThreadBB extends Thread {
    private MyService service;
    public MyThreadBB(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.methodB();
    }
}
