package com.java.tao.thread.core.chapter5.b.task_timer_2;



import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务运行时间："+ System.currentTimeMillis());
    }
}
