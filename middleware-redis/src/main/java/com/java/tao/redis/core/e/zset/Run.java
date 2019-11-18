package com.java.tao.redis.core.e.zset;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Run {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");

        jedis.zadd("mzset", 0d, "z");
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("a", 2d);
        map.put("c", 1d);
        jedis.zadd("mzset", map);
        Set<String> mzset = jedis.zrange("mzset", 0l, 10l);
        System.out.println(JSONObject.toJSONString(mzset));

    }
}
