package com.java.tao.gaode.pingan_20191114;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

public class Sort {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sort.class);

    public static void main(String[] args) {
        List<String> list = Arrays.asList("114.055547,22.538133 1_797_平安银行深圳江苏大厦支行",
                "114.107610,22.540543 2_800_平安银行总行营业部",
                "114.112612,22.568045 3_802_平安银行深圳笋岗支行",
                "114.082669,22.539898 4_803_平安银行深圳福虹支行",
                "114.055547,22.538133 108_5256_平安银行深圳西丽湖社区支行");
        Map<String, Object> m1 = sortMethod("m_101", list);
        System.out.println("*****************************************************************");
        if(m1!=null){
            for (Map.Entry<String, Object> m : m1.entrySet()){
                System.out.println(m.getKey()+" : "+m.getValue());
            }
        }

    }

    public static Map<String, Object> sortMethod(String methodName, List<String> list){
        try {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            List<BigDecimal> scores = new ArrayList<BigDecimal>();
            generatingScore(methodName, list, map, scores);
            Collections.sort(scores);
            resutl(map, scores);
            return map;
        }catch (Exception e){
            LOGGER.error("sortMethod[E]", e);
        }
        return null;
    }

    public static void generatingScore(String methodName, List<String> list, Map<String, Object> map, List<BigDecimal> scores) {
        try {
            for (String str : list){
                String[] split = str.split(" ");
                String xy = split[0];
                String yx = coordinate(xy);
                MistServiceCall mistServiceCall = new MistServiceCall();
                Method method = mistServiceCall.getClass().getMethod(methodName, String.class);
                BigDecimal r = (BigDecimal)method.invoke(mistServiceCall, yx);
                map.put(split[1], r);
                if(!scores.contains(r)){
                    scores.add(r);
                }else{
                    Random random = new Random();
                    int ran = random.nextInt(98)+1;
                    BigDecimal accuracy = new BigDecimal("0.000000"+ran);
                    BigDecimal nr = r.add(accuracy);
                    scores.add(nr);
                    map.put(split[1], nr);
                }
            }
        }catch (Exception e){
            LOGGER.error("generatingScore[E]", e);
        }
    }

    public static String coordinate(String xy){
        String[] split = xy.split(",");
        return split[1]+","+split[0];
    }

    public static void resutl(Map<String, Object> map, List<BigDecimal> scores){
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            BigDecimal value = (BigDecimal)next.getValue();
            int index = index(scores, value);
            next.setValue(index);
        }
    }

    public static int index(List<BigDecimal> list, BigDecimal value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(value) == 0) {
                return i + 1;
            }
        }
        return 0;
    }

}
