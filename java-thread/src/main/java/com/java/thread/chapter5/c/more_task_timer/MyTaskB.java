package com.java.thread.chapter5.c.more_task_timer;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.TimerTask;

public class MyTaskB extends TimerTask {
    @Override
    public void run() {
        System.out.println("B begin running time:"+ DateUtil.dateTimeToString(new Date()));
        System.out.println("B end run time:"+DateUtil.dateTimeToString(new Date()));
    }
}
