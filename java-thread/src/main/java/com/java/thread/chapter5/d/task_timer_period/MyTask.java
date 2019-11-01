package com.java.thread.chapter5.d.task_timer_period;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("running time:"+ DateUtil.dateTimeToString(new Date()));
    }
}
