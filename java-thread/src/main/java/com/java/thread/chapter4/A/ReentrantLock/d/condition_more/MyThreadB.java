package com.java.thread.chapter4.A.ReentrantLock.d.condition_more;

public class MyThreadB extends Thread {
    private MyService service;
    public MyThreadB(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.awaitB();
    }
}
