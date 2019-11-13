package com.java.tao.thread.core.chapter5.f.task_cancel;



import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) {
        System.out.println("now time:"+ System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date time = calendar.getTime();
        System.out.println("plan task start time:"+System.currentTimeMillis());
        MyTaskA a = new MyTaskA();
        MyTaskB b = new MyTaskB();
        Timer timer = new Timer();
        timer.schedule(a, time, 3000);
        timer.schedule(b, time, 3000);
    }
}
