package com.java.thread.chapter5.c.more_task_timer;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.TimerTask;

public class MyTaskA extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("A begin running time:"+ DateUtil.dateTimeToString(new Date()));
            Thread.sleep(20000);
            System.out.println("A end run time:"+DateUtil.dateTimeToString(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
