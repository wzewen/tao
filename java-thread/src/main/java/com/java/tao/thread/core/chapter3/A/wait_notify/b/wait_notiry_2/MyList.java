package com.java.tao.thread.core.chapter3.A.wait_notify.b.wait_notiry_2;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private static List<String> list = new ArrayList<String>();
    public static void add(){
        list.add("element");
    }

    public static int size(){
        return list.size();
    }
}
