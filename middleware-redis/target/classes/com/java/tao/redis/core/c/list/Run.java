package com.java.tao.redis.core.c.list;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.List;

public class Run {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");

        jedis.lpush("mlist", "a", "b", "c", "e");
        List<String> mlist = jedis.lrange("mlist", 0l, 10l);
        System.out.println(JSONObject.toJSONString(mlist));

    }
}
