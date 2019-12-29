package com.java.tao.design.single;

import com.java.tao.design.single.enumeration.Singleton;
import com.java.tao.design.single.lazy.SingleNoThreadSafe;
import com.java.tao.design.single.lazy.SingleThreadSafe;

public class Test {

    public static void main(String[] args) {
        SingleNoThreadSafe instance = SingleNoThreadSafe.getInstance();
        SingleThreadSafe instance1 = SingleThreadSafe.getInstance();

        com.java.tao.design.single.hungry.SingleThreadSafe singleThreadSafe = com.java.tao.design.single.hungry.SingleThreadSafe.getInstance();


        Singleton instance2 = Singleton.INSTANCE;

    }
}
