package com.java.thread.core.chapter4.B.ReentrantReadWriteLock.c.read_write_lock;

public class MyThreadB extends Thread {
    private MyService service;
    public MyThreadB(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.write();
    }
}
