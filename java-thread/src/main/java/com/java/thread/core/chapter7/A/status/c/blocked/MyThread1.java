package com.java.thread.core.chapter7.A.status.c.blocked;

public class MyThread1 extends Thread {
    @Override
    public void run(){
        MyService.method();
    }
}
