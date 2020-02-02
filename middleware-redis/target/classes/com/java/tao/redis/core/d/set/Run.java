package com.java.tao.redis.core.d.set;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class Run {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");

        jedis.sadd("mset", "a", "b", "1", "11");
        Set<String> mset = jedis.smembers("mset");
        System.out.println(JSONObject.toJSONString(mset));

    }
}
