package com.java.thread.chapter5.f.task_cancel;

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
        System.out.println("plan task start time:"+DateUtil.dateTimeToString(time));
        MyTaskA a = new MyTaskA();
        MyTaskB b = new MyTaskB();
        Timer timer = new Timer();
        timer.schedule(a, time, 3000);
        timer.schedule(b, time, 3000);
    }
}
