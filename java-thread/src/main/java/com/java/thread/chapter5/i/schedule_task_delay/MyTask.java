package com.java.thread.chapter5.i.schedule_task_delay;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("task start running... time:"+ DateUtil.dateTimeToString(new Date()));
    }
}
