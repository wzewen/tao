package com.java.tao.redis.core.b.hash;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Run {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");

        HashMap<String, String> user = new HashMap<String, String>();
        user.put("username", "lilith");
        user.put("sex", "woman");
        user.put("age", "1004");
        jedis.hset("eva:1", user);

        String username = jedis.hget("eva:1", "username");
        System.out.println("field username : "+username);
        Map<String, String> map = jedis.hgetAll("eva:1");
        System.out.println("hash eva:1 --> "+ JSONObject.toJSONString(map));

    }
}
