package com.java.tao.thread.core.chapter5.c.more_task_timer;



import java.util.Date;
import java.util.TimerTask;

public class MyTaskB extends TimerTask {
    @Override
    public void run() {
        System.out.println("B begin running time:"+ System.currentTimeMillis());
        System.out.println("B end run time:"+System.currentTimeMillis());
    }
}
