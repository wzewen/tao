package com.java.thread.core.chapter7.B.group.a.group_add_thread;

public class Run {

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadGroup group = new ThreadGroup("my self thread group");
        Thread t1 = new Thread(group, a);
        Thread t2 = new Thread(group, b);
        t1.start();
        t2.start();
        System.out.println("thread group active size --> "+group.activeCount());
        System.out.println("thread group name --> "+group.getName());

    }
}
