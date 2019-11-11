package com.java.tao.thread.core.chapter5.i.schedule_task_delay;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Timer timer = new Timer();
        System.out.println("now time:"+ DateUtil.dateTimeToString(new Date()));
        timer.schedule(task, 3000);
    }
}
