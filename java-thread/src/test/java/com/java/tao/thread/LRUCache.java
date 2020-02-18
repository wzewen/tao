package com.java.tao.thread;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap {

    private final int CACHE_SIZE;

    public LRUCache(int cacheSize){
        /**
         * 这块就是设置一个hashmap的初始大小，同时最后一个true指的是让linkedHashMap按照访问顺序来进行排序，
         * 最近访问的放在头，最老访问的放在尾
         */
        super((int)Math.ceil(cacheSize/0.75)+1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry eldest){
        /**
         * 这个意思就是说当map中当数据大于指定当缓存个数当时候，就会自动删除最老的数据
         */
        return size() > CACHE_SIZE;
    }

}
