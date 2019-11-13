package com.java.tao.thread.core.chapter5.a.task_timer_1;

import java.util.TimerTask;

public class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("任务运行时间："+ System.currentTimeMillis());
    }
}
