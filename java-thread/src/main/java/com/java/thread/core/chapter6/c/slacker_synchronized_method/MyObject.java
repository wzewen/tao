package com.java.thread.core.chapter6.c.slacker_synchronized_method;

public class MyObject {
    private static MyObject myObject = null;
    private MyObject(){}
    synchronized public static MyObject getInstance(){
        if(myObject==null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myObject = new MyObject();
        }
        return myObject;
    }
}
