package com.java.thread.core.chapter5.b.task_timer_2;

import com.java.tao.utils.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) {
        System.out.println("当前时间："+ DateUtil.dateTimeToString(new Date()));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) -10);
        Date date = calendar.getTime();
        System.out.println("计划运行时间："+DateUtil.dateTimeToString(date));
        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, date);

    }
}
