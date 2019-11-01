package com.java.thread.chapter7.B.group.a.group_add_thread;

public class ThreadB extends Thread {
    @Override
    public void run(){
        while (true){
            System.out.println("thread B running ...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
