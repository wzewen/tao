package com.java.thread.core.chapter5.a.task_timer_1;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("任务运行时间："+ DateUtil.dateTimeToString(new Date()));
    }
}
