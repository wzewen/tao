package com.java.tao.design.single.inner_class;

public class Singleton {
    private static class SingletonHolder{
        private static final Singleton SINGLETON = new Singleton();
    }
    private Singleton(){}

    public static Singleton getInstance(){
        return SingletonHolder.SINGLETON;
    }

}
