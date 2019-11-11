package com.java.tao.thread.core.chapter4.A.ReentrantLock.b.test;

public class MyThreadAA extends Thread {
    private MyService service;
    public MyThreadAA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.methodA();
    }
}
