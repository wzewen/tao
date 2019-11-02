package com.java.thread.core.chapter5.e.task_timer_later;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("task begin time:"+ DateUtil.dateTimeToString(new Date()));
            Thread.sleep(5000);
            System.out.println("task end   time:"+ DateUtil.dateTimeToString(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
