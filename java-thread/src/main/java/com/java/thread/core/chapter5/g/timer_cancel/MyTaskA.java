package com.java.thread.core.chapter5.g.timer_cancel;

import com.java.tao.utils.DateUtil;

import java.util.Date;
import java.util.TimerTask;

public class MyTaskA extends TimerTask {
    @Override
    public void run() {
        System.out.println("A running time:"+ DateUtil.dateTimeToString(new Date()));
    }
}
