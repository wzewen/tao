package com.java.thread.chapter7.A.status.c.blocked;

public class MyThread2 extends Thread {
    @Override
    public void run(){
        MyService.method();
    }
}
