package com.java.tao.redis.core.a.string;

import redis.clients.jedis.Jedis;

public class Run {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
        //连接测试
        System.out.println("redis status : "+jedis.ping());
        //字符串存取
        jedis.set("username", "zhangsan");
        System.out.println(jedis.get("username"));

    }

}
