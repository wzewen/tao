package com.java.tao.thread.core.chapter5.d.task_timer_period;



import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("running time:"+ System.currentTimeMillis());
    }
}
