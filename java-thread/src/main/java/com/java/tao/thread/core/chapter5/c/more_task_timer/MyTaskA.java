package com.java.tao.thread.core.chapter5.c.more_task_timer;



import java.util.Date;
import java.util.TimerTask;

public class MyTaskA extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("A begin running time:"+ System.currentTimeMillis());
            Thread.sleep(20000);
            System.out.println("A end run time:"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
