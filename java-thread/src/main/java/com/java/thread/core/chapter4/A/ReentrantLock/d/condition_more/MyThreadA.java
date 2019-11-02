package com.java.thread.core.chapter4.A.ReentrantLock.d.condition_more;

public class MyThreadA extends Thread {
    private MyService service;
    public MyThreadA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.awaitA();
    }
}
