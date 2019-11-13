package com.java.tao.thread.core.chapter5.j.schedule_task_delay_period;



import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("task running... time:"+ System.currentTimeMillis());
    }
}
