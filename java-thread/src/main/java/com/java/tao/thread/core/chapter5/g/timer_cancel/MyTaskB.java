package com.java.tao.thread.core.chapter5.g.timer_cancel;



import java.util.Date;
import java.util.TimerTask;

public class MyTaskB extends TimerTask {
    @Override
    public void run() {
        System.out.println("B running time:"+ System.currentTimeMillis());
    }
}
