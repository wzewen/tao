package com.java.tao.thread.core.chapter5.b.task_timer_2;



import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) {
        System.out.println("当前时间："+ System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) -10);
        Date date = calendar.getTime();
        System.out.println("计划运行时间："+System.currentTimeMillis());
        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, date);

    }
}
