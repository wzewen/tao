package com.java.tao.thread.core.chapter5.i.schedule_task_delay;



import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("task start running... time:"+ System.currentTimeMillis());
    }
}
