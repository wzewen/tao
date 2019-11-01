package com.java.thread.chapter7.A.status.b.timed_waiting;

public class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println("begin ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end .");
    }
}
