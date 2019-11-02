package com.java.thread.core.chapter5.e.task_timer_later;

import com.java.tao.utils.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) {
        System.out.println("now time:"+ DateUtil.dateTimeToString(new Date()));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date time = calendar.getTime();
        System.out.println("plan start time:"+DateUtil.dateTimeToString(time));
        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, time, 3000);
    }
}
