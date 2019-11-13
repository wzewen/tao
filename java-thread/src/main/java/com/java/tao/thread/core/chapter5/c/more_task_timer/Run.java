package com.java.tao.thread.core.chapter5.c.more_task_timer;



import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) {
        System.out.println("now time:"+ System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date time = calendar.getTime();
        System.out.println("A plan run time:"+System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 15);
        Date time1 = calendar.getTime();
        System.out.println("B plan run time:"+System.currentTimeMillis());

        MyTaskA a = new MyTaskA();
        MyTaskB b = new MyTaskB();
        Timer timer = new Timer();
        timer.schedule(a, time);
        timer.schedule(b, time1);
    }
}
