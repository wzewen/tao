package com.java.tao.thread.core.chapter5.g.timer_cancel;



import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start time:"+ System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);
        Date time = calendar.getTime();
        System.out.println("plan start running time:"+System.currentTimeMillis());
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
