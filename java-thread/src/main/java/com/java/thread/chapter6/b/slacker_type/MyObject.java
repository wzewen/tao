package com.java.thread.chapter6.b.slacker_type;

public class MyObject {
    private static MyObject myObject = null;
    private MyObject(){

    }
    public static MyObject getInstance(){
        if(myObject==null){
            myObject = new MyObject();
        }
        return myObject;
    }
}
