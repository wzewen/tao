package com.java.tao.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.json.JSONException;

import java.util.*;

public class A{
    public static void main(String[] args) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bb", 1);
        jsonObject.put("aa", 2);
        Map<String, Object> map = new TreeMap<String, Object>();
        map.put("b","bbb");
        map.put("a","aaa");
        map.put("c", jsonObject);
        System.out.println(JSONObject.toJSONString(map, SerializerFeature.MapSortField));

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("b","bbb");
        map2.put("a","aaa");
        map2.put("c", jsonObject.toString());
        System.out.println(map2.toString());

    }
}