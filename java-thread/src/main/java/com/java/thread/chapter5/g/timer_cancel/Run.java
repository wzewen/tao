package com.java.thread.chapter5.g.timer_cancel;

import com.java.tao.utils.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start time:"+ DateUtil.dateTimeToString(new Date()));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);
        Date time = calendar.getTime();
        System.out.println("plan start running time:"+DateUtil.dateTimeToString(time));
        MyTaskA a = new MyTaskA();
        MyTaskB b = new MyTaskB();
        Timer timer = new Timer();
        timer.schedule(a, time, 3000);
        timer.schedule(b, time, 3000);
        Thread.sleep(15000);
        System.out.println("15s timer cancel.");
        timer.cancel();
    }
}
