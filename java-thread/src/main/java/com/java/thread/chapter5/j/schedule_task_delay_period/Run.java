package com.java.thread.chapter5.j.schedule_task_delay_period;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Timer timer = new Timer();
        System.out.println("now time:"+ DateUtil.dateTimeToString(new Date()));
        timer.schedule(task, 3000, 5000);
    }
}
