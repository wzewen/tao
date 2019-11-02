package com.java.thread.core.chapter4.B.ReentrantReadWriteLock.c.read_write_lock;

public class MyThreadA extends Thread {
    private MyService service;
    public MyThreadA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.read();
    }
}
