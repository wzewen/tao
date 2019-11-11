package com.java.tao.thread.core.chapter4.A.ReentrantLock.e.condition_producer_consumer;

public class MyThreadB extends Thread{
    private MyService service;
    public MyThreadB(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        for (int i=0; i<10000; i++){
            service.get();
        }
    }
}
