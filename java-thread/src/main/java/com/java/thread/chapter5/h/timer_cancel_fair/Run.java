package com.java.thread.chapter5.h.timer_cancel_fair;

import java.util.Date;
import java.util.Timer;

public class Run {

    public static void main(String[] args) {
        for (int i=0; i<1000; i++){
            MyTask task = new MyTask(i);
            Timer timer = new Timer();
            timer.schedule(task, new Date());
            timer.cancel();
        }
    }
}
