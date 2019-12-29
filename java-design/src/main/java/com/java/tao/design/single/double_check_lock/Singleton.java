package com.java.tao.design.single.double_check_lock;

public class Singleton {
    private static Singleton singleton;
    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
