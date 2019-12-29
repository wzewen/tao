package com.java.tao.design.single.lazy;

public class SingleNoThreadSafe {
    private static SingleNoThreadSafe singleNoThreadSafe;
    private SingleNoThreadSafe(){
    }

    public static SingleNoThreadSafe getInstance(){
        if(singleNoThreadSafe==null){
            singleNoThreadSafe = new SingleNoThreadSafe();
        }
        return singleNoThreadSafe;
    }
}
