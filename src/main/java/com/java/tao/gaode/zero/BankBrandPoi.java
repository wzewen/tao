package com.java.tao.gaode.zero;

import com.alibaba.fastjson.JSONObject;
import com.java.tao.utils.HttpUtils;

import java.util.*;

public class BankBrandPoi {


    public static void main(String[] args) {

        Map<String, String> bank = new LinkedHashMap<>();
        bank.put("中信银行", "中信银行,中信银行(国际)");
        bank.put("广发银行", "广发银行");
        bank.put("招商银行", "招商银行");
        bank.put("民生银行", "中国民生银行");
        bank.put("兴业银行", "兴业银行,法国兴业银行");
        bank.put("浦发银行", "浦发银行");
        bank.put("光大银行", "中国光大银行");
        bank.put("中国银行", "中国银行,中国银行ATM");
        bank.put("工商银行", "中国工商银行");

        String xy = "114.053333,22.516364";
        String[] split = xy.split(",");
        String x = split[0];
        String y = split[1];

        List<String> r1 = new ArrayList<>();
        List<String> r2 = new ArrayList<>();
        List<String> r0 = new ArrayList<>();

        List<String> error = new ArrayList<>();

        for (Map.Entry<String, String> m : bank.entrySet()){
            try{
                String url = "http://140.205.217.247/dmpapi/geo/cyclepoi?point_x="+x+"&point_y="+y+"&point_r=2.5&limit=500&brandname="+m.getValue();
                String s = HttpUtils.httpGetReq(url);
                Object o = JSONObject.parseObject(s).getJSONObject("data").getJSONArray("area_data").get(0);
                JSONObject object = JSONObject.parseObject(JSONObject.toJSONString(o));
                Object poi_total = object.get("poi_total");
                if(Integer.parseInt(poi_total+"")==0){
                    r0.add(m.getKey()+" "+poi_total+"");
                }else{
                    r1.add(m.getKey());
                    r2.add(poi_total+"");
                }
                Thread.sleep(1000);
            }catch (Exception e){
                error.add(m.getKey());
            }
        }

        System.out.println();
        for (String r : r1){
            System.out.println(r);
        }
        System.out.println();
        for (String r : r2){
            System.out.println(r);
        }
        System.out.println();
        for (String r : r0){
            System.out.println(r);
        }
        System.out.println("****************************");
        for (String e : error){
            System.out.println(e);
        }

    }

}
