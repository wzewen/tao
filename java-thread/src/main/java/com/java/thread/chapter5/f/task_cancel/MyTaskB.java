package com.java.thread.chapter5.f.task_cancel;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.TimerTask;

public class MyTaskB extends TimerTask {
    @Override
    public void run() {
        System.out.println("B task running start time:"+ DateUtil.dateTimeToString(new Date()));
    }
}
