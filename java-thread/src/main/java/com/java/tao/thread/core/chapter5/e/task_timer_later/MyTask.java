package com.java.tao.thread.core.chapter5.e.task_timer_later;



import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("task begin time:"+ System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("task end   time:"+ System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
