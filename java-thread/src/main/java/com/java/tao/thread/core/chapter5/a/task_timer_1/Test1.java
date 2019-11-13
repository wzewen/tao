package com.java.tao.thread.core.chapter5.a.task_timer_1;



import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Test1 {

    public static void main(String[] args) {
        System.out.println("当前时间："+ System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date date = calendar.getTime();

        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, date);

    }
}
