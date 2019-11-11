package com.java.tao.thread.core.chapter6.a.hungry_man;

public class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println(MyObject.getInstance().hashCode());
    }
}
