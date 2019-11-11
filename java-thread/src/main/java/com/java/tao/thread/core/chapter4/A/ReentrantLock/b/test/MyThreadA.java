package com.java.tao.thread.core.chapter4.A.ReentrantLock.b.test;

public class MyThreadA extends Thread {
    private MyService service;
    public MyThreadA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.methodA();
    }
}
