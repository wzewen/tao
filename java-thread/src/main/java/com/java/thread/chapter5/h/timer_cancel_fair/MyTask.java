package com.java.thread.chapter5.h.timer_cancel_fair;

import java.util.TimerTask;

public class MyTask extends TimerTask {
    private int i;
    public MyTask(int i){
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println("task num:"+i+" not cancel.");
    }
}
