package com.java.tao.thread.core.chapter4.A.ReentrantLock.e.condition_producer_consumer;

public class MyThreadA extends Thread{
    private MyService service;
    public MyThreadA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        for (int i=0; i<10000; i++){
            service.set();
        }
    }
}
