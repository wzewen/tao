package com.java.tao.thread.core.chapter5.f.task_cancel;



import java.util.Date;
import java.util.TimerTask;

public class MyTaskB extends TimerTask {
    @Override
    public void run() {
        System.out.println("B task running start time:"+ System.currentTimeMillis());
    }
}
