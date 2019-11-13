package com.java.tao.thread.core.chapter5.e.task_timer_later;



import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) {
        System.out.println("now time:"+ System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date time = calendar.getTime();
        System.out.println("plan start time:"+System.currentTimeMillis());
        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, time, 3000);
    }
}
