package com.java.thread.core.chapter7.B.group.a.group_add_thread;

public class ThreadA extends Thread {
    @Override
    public void run(){
        while (true){
            System.out.println("thread A running ...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
