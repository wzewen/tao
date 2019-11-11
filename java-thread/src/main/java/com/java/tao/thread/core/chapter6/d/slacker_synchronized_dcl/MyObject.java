package com.java.tao.thread.core.chapter6.d.slacker_synchronized_dcl;

public class MyObject {
    private static MyObject myObject = null;
    private MyObject(){}
    public static MyObject getInstance(){
        if(myObject==null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (MyObject.class){
                if(myObject==null){
                    myObject = new MyObject();
                }
            }
        }
        return myObject;
    }
}
