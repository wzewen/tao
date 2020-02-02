package com.java.tao.redis.springboot;

import com.alibaba.fastjson.JSONObject;
import com.java.tao.redis.springboot.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public String test(@RequestParam(name = "key") String key,
                       @RequestParam(name = "val") String val){
        redisUtil.set(key, val);
        Object o = redisUtil.get(key);
        return JSONObject.toJSONString(o);
    }
}
