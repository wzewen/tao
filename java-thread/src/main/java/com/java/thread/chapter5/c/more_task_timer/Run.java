package com.java.thread.chapter5.c.more_task_timer;

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
        System.out.println("A plan run time:"+DateUtil.dateTimeToString(time));
        calendar.add(Calendar.SECOND, 15);
        Date time1 = calendar.getTime();
        System.out.println("B plan run time:"+DateUtil.dateTimeToString(time1));

        MyTaskA a = new MyTaskA();
        MyTaskB b = new MyTaskB();
        Timer timer = new Timer();
        timer.schedule(a, time);
        timer.schedule(b, time1);
    }
}
