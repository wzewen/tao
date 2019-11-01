package com.java.thread.chapter5.f.task_cancel;

import java.util.TimerTask;

public class MyTaskA extends TimerTask {
    @Override
    public void run() {
        System.out.println("A task start running...");
        this.cancel();
        System.out.println("A task cancel self.");
    }
}
