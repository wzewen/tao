package com.java.tao.design.single.hungry;

public class SingleThreadSafe {
    private static SingleThreadSafe singleThreadSafe = new SingleThreadSafe();
    private SingleThreadSafe(){}

    public static SingleThreadSafe getInstance(){
        return singleThreadSafe;
    }

}
