package com.java.thread.chapter5.j.schedule_task_delay_period;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("task running... time:"+ DateUtil.dateTimeToString(new Date()));
    }
}
