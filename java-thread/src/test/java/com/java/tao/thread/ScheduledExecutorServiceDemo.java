package com.java.tao.thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        long intervalPeriod = 5;
        /**
         * 根据城市code获取城市数据
         */
        executor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("任务执行了...");
            }
        },1, intervalPeriod, TimeUnit.SECONDS);
    }
}
