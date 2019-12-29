package com.java.tao.design.single.lazy;

public class SingleThreadSafe {
    private static SingleThreadSafe singleThreadSafe;
    private SingleThreadSafe(){
    }

    public static synchronized SingleThreadSafe getInstance(){
        if(singleThreadSafe==null){
            singleThreadSafe = new SingleThreadSafe();
        }
        return singleThreadSafe;
    }
}
