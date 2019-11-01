package com.java.thread.chapter5.a.task_timer_1;

import com.java.tao.utils.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Test1 {

    public static void main(String[] args) {
        System.out.println("当前时间："+ DateUtil.dateTimeToString(new Date()));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date date = calendar.getTime();

        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, date);

    }
}
