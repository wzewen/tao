package com.java.tao.gaode.pingan_20191114;

import com.alibaba.fastjson.JSONObject;
import com.java.tao.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MistServiceCall {
    private static final Logger LOGGER = LoggerFactory.getLogger(MistServiceCall.class);

    /**
     * 常驻人口分布	月均客流画像-日均客流指数
     * case: http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=month&field=day&month=201909&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_101(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=month&field=day&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            Integer integer = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("month").getInteger("day");
            if(integer!=null){
                return new BigDecimal(integer+"");
            }else {
                return BigDecimal.ZERO;
            }
        }catch (Exception e){
            
            LOGGER.error("101[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 人口标签特性-年龄	月均客流画像-年龄结构
     * juvenile : 0-18
     * youth : 16-24
     * adult : 25-34
     * midage : 35-44
     * highage : 45-54
     * oldage : 55-100
     *
     * case: http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=age&value_type=1&month=201909&yx=22.538133,114.055547
     * @return
     */
    public static BigDecimal m_102(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=age&value_type=1&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("month").getJSONObject("percent").getJSONObject("age");
            BigDecimal juvenile = (jsonObject.getBigDecimal("juvenile").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(0.5));
            BigDecimal youth = (jsonObject.getBigDecimal("youth").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.2));
            BigDecimal adult = (jsonObject.getBigDecimal("adult").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.5));
            BigDecimal midage = (jsonObject.getBigDecimal("midage").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.4));
            BigDecimal highage = (jsonObject.getBigDecimal("highage").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.3));
            BigDecimal oldage = (jsonObject.getBigDecimal("oldage").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.1));
            BigDecimal sum = juvenile.add(youth).add(adult).add(midage).add(highage).add(oldage);
            return sum.setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("102[E] yx={}",yx);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 人口标签特性-资产	月均客流画像-资产等级分布
     * 工薪 : salariat
     * 中产 : midclass
     * 富豪 : plutocrat
     * 超级富豪 : superrich
     *
     * case: http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=rank&value_type=1&month=201909&yx=22.538133,114.055547
     * @return
     */
    public static BigDecimal m_103(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=rank&value_type=1&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("month").getJSONObject("percent").getJSONObject("rank");
            BigDecimal salariat = (jsonObject.getBigDecimal("salariat").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1));
            BigDecimal midclass = (jsonObject.getBigDecimal("midclass").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.5));
            BigDecimal plutocrat = (jsonObject.getBigDecimal("plutocrat").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(2));
            BigDecimal superrich = (jsonObject.getBigDecimal("superrich").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(3));
            BigDecimal sum = salariat.add(midclass).add(plutocrat).add(superrich);
            return sum.setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("103[E] yx={}",yx);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 人口标签特性-学历	月均客流画像-学历分布
     * 专科 junior
     * 本科 bachelor
     * 硕士 master
     * 博士 doctor
     *
     * case: http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=edu&value_type=1&month=201909&yx=22.538133,114.055547
     * @return
     */
    public static BigDecimal m_104(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=edu&value_type=1&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("month").getJSONObject("percent").getJSONObject("edu");
            BigDecimal junior = (jsonObject.getBigDecimal("junior").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(2));
            BigDecimal bachelor = (jsonObject.getBigDecimal("bachelor").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.2));
            BigDecimal master = (jsonObject.getBigDecimal("master").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.5));
            BigDecimal doctor = (jsonObject.getBigDecimal("doctor").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(3));
            BigDecimal sum = junior.add(bachelor).add(master).add(doctor);
            return sum.setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("104[E] yx={}",yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 人口标签特性-家庭主妇	月均客流画像-职业分布
     * housewife
     *
     * case: http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=occup&value_type=1&month=201909&yx=22.538133,114.055547
     * @return
     */
    public static BigDecimal m_105(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=occup&value_type=1&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("month").getJSONObject("percent").getJSONObject("occup");
            BigDecimal housewife = jsonObject.getBigDecimal("housewife").setScale(6, RoundingMode.HALF_UP);
            BigDecimal result = BigDecimal.ONE.subtract(housewife);
            return result.setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("105[E] yx={}",yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 人口标签特性-政事业单位员工	月均客流画像-职业分布
     * 公务员      officer
     * 公司职员     staff
     * 医疗人员     medical
     * 教职工      teacher
     * 科研人员     researcher
     *
     * case: http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=occup&value_type=1&month=201909&yx=22.538133,114.055547
     * @return
     */
    public static BigDecimal m_106(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=occup&value_type=1&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("month").getJSONObject("percent").getJSONObject("occup");
            BigDecimal officer = jsonObject.getBigDecimal("officer").setScale(6, RoundingMode.HALF_UP);
            BigDecimal staff = jsonObject.getBigDecimal("staff").setScale(6, RoundingMode.HALF_UP);
            BigDecimal medical = jsonObject.getBigDecimal("medical").setScale(6, RoundingMode.HALF_UP);
            BigDecimal teacher = jsonObject.getBigDecimal("teacher").setScale(6, RoundingMode.HALF_UP);
            BigDecimal researcher = jsonObject.getBigDecimal("researcher").setScale(6, RoundingMode.HALF_UP);
            BigDecimal result = officer.add(staff).add(medical).add(teacher).add(researcher);
            return result.setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("106[E] yx={}",yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 人口标签特性-蓝领工人	月均客流画像-职业分布
     * 出租车司机    taxi
     * 快递员      deliver
     * 服务人员     servant
     * 货车司机     truck
     *
     * case: http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=occup&value_type=1&month=201909&yx=22.538133,114.055547
     * @return
     */
    public static BigDecimal m_107(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=occup&value_type=1&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("month").getJSONObject("percent").getJSONObject("occup");
            BigDecimal taxi = jsonObject.getBigDecimal("taxi").setScale(6, RoundingMode.HALF_UP);
            BigDecimal deliver = jsonObject.getBigDecimal("deliver").setScale(6, RoundingMode.HALF_UP);
            BigDecimal servant = jsonObject.getBigDecimal("servant").setScale(6, RoundingMode.HALF_UP);
            BigDecimal truck = jsonObject.getBigDecimal("truck").setScale(6, RoundingMode.HALF_UP);
            BigDecimal result = BigDecimal.ONE.subtract(taxi).subtract(deliver).subtract(servant).subtract(truck);
            return result.setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("107[E] yx={}",yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 工作日客流	工作日客流画像-日均客流指数
     * case: http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=weekday&field=day&month=201909&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_108(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=weekday&field=day&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            Integer integer = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("weekday").getInteger("day");
            if(integer!=null){
                return new BigDecimal(integer+"");
            }else {
                return BigDecimal.ZERO;
            }
        }catch (Exception e){
            
            LOGGER.error("108[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 节假日客流	节假日客流画像-日均客流指数
     * case: http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=weekend&field=day&month=201909&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_109(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=weekend&field=day&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            Integer integer = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("weekend").getInteger("day");
            if(integer!=null){
                return new BigDecimal(integer+"");
            }else {
                return BigDecimal.ZERO;
            }
        }catch (Exception e){
            
            LOGGER.error("109[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 月均客流24小时方差	月均客流画像-24小时客流分布
     * case: http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=month&field=hour&month=201909&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_110(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=month&field=hour&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("month").getJSONObject("hour");
            double variance = variance(jsonObject);
            return new BigDecimal(variance).setScale(4, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("110[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 方差
     */
    public static double variance(JSONObject object) {
        double[] x = new double[24];
        x[0] = object.getDouble("0");
        x[1] = object.getDouble("1");
        x[2] = object.getDouble("2");
        x[3] = object.getDouble("3");
        x[4] = object.getDouble("4");
        x[5] = object.getDouble("5");
        x[6] = object.getDouble("6");
        x[7] = object.getDouble("7");
        x[8] = object.getDouble("8");
        x[9] = object.getDouble("9");
        x[10] = object.getDouble("10");
        x[11] = object.getDouble("11");
        x[12] = object.getDouble("12");
        x[13] = object.getDouble("13");
        x[14] = object.getDouble("14");
        x[15] = object.getDouble("15");
        x[16] = object.getDouble("16");
        x[17] = object.getDouble("17");
        x[18] = object.getDouble("18");
        x[19] = object.getDouble("19");
        x[20] = object.getDouble("20");
        x[21] = object.getDouble("21");
        x[22] = object.getDouble("22");
        x[23] = object.getDouble("23");
        int m=x.length;
        double sum=0;
        for(int i=0;i<m;i++){//求和
            sum+=x[i];
        }
        double dAve=sum/m;//求平均值
        double dVar=0;
        for(int i=0;i<m;i++){//求方差
            dVar+=(x[i]-dAve)*(x[i]-dAve);
        }
        return dVar/m;
    }


    /**
     * 24小时节假日客流方差	节假日客流画像-24小时客流分布
     * case: http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=weekend&field=hour&month=201909&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_111(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=weekend&field=hour&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("weekend").getJSONObject("hour");
            double variance = variance(jsonObject);
            return new BigDecimal(variance).setScale(4, BigDecimal.ROUND_HALF_UP);

        }catch (Exception e){
            
            LOGGER.error("111[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 24小时工作日客流方差	工作日客流画像-24小时客流分布
     * case: http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=weekday&field=hour&month=201909&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_112(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow?type=0&type_info=2.5&magic=1&loc_type=weekday&field=hour&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("weekday").getJSONObject("hour");
            double variance = variance(jsonObject);
            return new BigDecimal(variance).setScale(4, BigDecimal.ROUND_HALF_UP);

        }catch (Exception e){
            
            LOGGER.error("112[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 201	活跃人口竞业指数	月均客流画像-行业分布
     * case: http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=ind&month=201909&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_201(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/flow/profile?type=0&type_info=2.5&magic=1&loc_type=month&field=ind&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            BigDecimal bank = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("month").getJSONObject("percent").getJSONObject("ind").getBigDecimal("bank");
            return BigDecimal.ONE.subtract(bank).setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("201[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 202	居住人口竞业指数	居住人口画像-行业分布
     * case: http://pre-mist-service.amap.com/mist/profile/base?type=0&type_info=2.5&magic=1&loc_type=home&field=ind&month=201909&value_type=1&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_202(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/profile/base?type=0&type_info=2.5&magic=1&loc_type=home&field=ind&month=201909&value_type=1&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            BigDecimal bank = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("home").getJSONObject("percent").getJSONObject("ind").getBigDecimal("bank");
            return BigDecimal.ONE.subtract(bank).setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("202[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 203	工作人口竞业指数	工作人口画像-行业分布
     * case: http://pre-mist-service.amap.com/mist/profile/base?type=0&type_info=2.5&magic=1&loc_type=company&field=ind&month=201909&value_type=1&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_203(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/profile/base?type=0&type_info=2.5&magic=1&loc_type=company&field=ind&month=201909&value_type=1&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            BigDecimal bank = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("company").getJSONObject("percent").getJSONObject("ind").getBigDecimal("bank");
            return BigDecimal.ONE.subtract(bank).setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("203[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 204	网点附近竞业分布情况-中信银行	地理数据-品牌poi统计
     * @param yx
     * @return
     */
    public static BigDecimal m_204(String yx){
        return bankPoi(yx, "中信银行,中信银行(国际)", 204);
    }

    public static BigDecimal bankPoi(String yx, String bank, int num){
        try {
            String[] split = yx.split(",");
            String url = "http://140.205.217.247/dmpapi/geo/cyclepoi?point_x="+split[1]+"&point_y="+split[0]+"&point_r=2.5&appname=insight-api&limit=500&brandname="+bank;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            Object o = JSONObject.parseObject(s).getJSONObject("data").getJSONArray("area_data").get(0);
            JSONObject object = JSONObject.parseObject(JSONObject.toJSONString(o));
            Integer poi_total = object.getInteger("poi_total");
            if(poi_total==null){
                poi_total = 0;
            }
            int diff = 100 - poi_total;
            return new BigDecimal(diff+"");
        }catch (Exception e){
            
            LOGGER.error(num+"[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 205	网点附近竞业分布情况-广发银行	地理数据-品牌poi统计
     * @param yx
     * @return
     */
    public static BigDecimal m_205(String yx){
        return bankPoi(yx, "广发银行", 205);
    }

    /**
     * 206	网点附近竞业分布情况-招商银行	地理数据-品牌poi统计
     * @param yx
     * @return
     */
    public static BigDecimal m_206(String yx){
        return bankPoi(yx, "招商银行", 206);
    }

    /**
     * 207	网点附近竞业分布情况-民生银行	地理数据-品牌poi统计
     * @param yx
     * @return
     */
    public static BigDecimal m_207(String yx){
        return bankPoi(yx, "中国民生银行", 207);
    }

    /**
     * 208	网点附近竞业分布情况-兴业银行	地理数据-品牌poi统计
     * @param yx
     * @return
     */
    public static BigDecimal m_208(String yx){
        return bankPoi(yx, "兴业银行,法国兴业银行", 208);
    }

    /**
     * 209	网点附近竞业分布情况-浦发银行	地理数据-品牌poi统计
     * @param yx
     * @return
     */
    public static BigDecimal m_209(String yx){
        return bankPoi(yx, "浦发银行", 209);
    }

    /**
     * 210	网点附近竞业分布情况-光大银行	地理数据-品牌poi统计
     * @param yx
     * @return
     */
    public static BigDecimal m_210(String yx){
        return bankPoi(yx, "中国光大银行", 210);
    }

    /**
     * 211	网点附近竞业分布情况-中国银行	地理数据-品牌poi统计
     * @param yx
     * @return
     */
    public static BigDecimal m_211(String yx){
        return bankPoi(yx, "中国银行,中国银行ATM", 211);
    }

    /**
     * 212	网点附近竞业分布情况-工商银行	地理数据-品牌poi统计
     * @param yx
     * @return
     */
    public static BigDecimal m_212(String yx){
        return bankPoi(yx, "中国工商银行", 212);
    }

    /**
     * 301	社区常驻人口指数	居住人口画像-日均人口总数
     * case: http://pre-mist-service.amap.com/mist/population?type=0&type_info=2.5&magic=1&loc_type=home&month=201909&yx=22.538133,114.055547
     * @param yx
     * @return
     */
    public static BigDecimal m_301(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/population?type=0&type_info=2.5&magic=1&loc_type=home&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            Integer home = JSONObject.parseObject(s).getJSONObject("content").getInteger("home");
            return new BigDecimal(home+"");
        }catch (Exception e){
            
            LOGGER.error("301[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 302	社区人口年龄结构	居住人口画像-年龄结构
     * case: http://pre-mist-service.amap.com/mist/profile/base?type=0&type_info=2.5&value_type=1&field=age&magic=1&loc_type=home&month=201909&yx=22.538133,114.055547
     *      * juvenile : 0-18
     *      * youth : 16-24
     *      * adult : 25-34
     *      * midage : 35-44
     *      * highage : 45-54
     *      * oldage : 55-100
     *
     * @param yx
     * @return
     */
    public static BigDecimal m_302(String yx){
        try {
            String url = "http://pre-mist-service.amap.com/mist/profile/base?type=0&type_info=2.5&value_type=1&field=age&magic=1&loc_type=home&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content").getJSONObject("home").getJSONObject("percent").getJSONObject("age");
            BigDecimal juvenile = (jsonObject.getBigDecimal("juvenile").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(0.5));
            BigDecimal youth = (jsonObject.getBigDecimal("youth").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.2));
            BigDecimal adult = (jsonObject.getBigDecimal("adult").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.5));
            BigDecimal midage = (jsonObject.getBigDecimal("midage").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.4));
            BigDecimal highage = (jsonObject.getBigDecimal("highage").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.3));
            BigDecimal oldage = (jsonObject.getBigDecimal("oldage").setScale(6, RoundingMode.HALF_UP)).multiply(new BigDecimal(1.1));
            BigDecimal sum = juvenile.add(youth).add(adult).add(midage).add(highage).add(oldage);
            return sum.setScale(6, BigDecimal.ROUND_HALF_UP);
        }catch (Exception e){
            
            LOGGER.error("302[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 303	社区周边设施-三甲医院	地理数据-聚客点统计
     *
     * @param yx
     * @return
     */
    public static BigDecimal m_303(String yx){
        return poiAttraction(yx, "090101", 303);
    }

    public static BigDecimal poiAttraction(String yx, String typeCode, int num){
        try {
            String url = "http://pre-mist-service.amap.com/mist/poi/attraction?type=0&type_info=2.5&magic=1&typecode="+typeCode+"&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            Integer integer = JSONObject.parseObject(s).getJSONObject("content").getJSONObject(typeCode).getInteger("cnt");
            if(integer!=null){
                return new BigDecimal(integer+"");
            }
        }catch (Exception e){
            
            LOGGER.error(num+"[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 304	社区周边设施-幼儿园	地理数据-聚客点统计
     * @param yx
     * @return
     */
    public static BigDecimal m_304(String yx){
        return poiAttraction(yx, "141204", 304);
    }

    /**
     * 305	社区周边设施-小学	地理数据-聚客点统计
     * @param yx
     * @return
     */
    public static BigDecimal m_305(String yx){
        return poiAttraction(yx, "141203", 305);
    }

    /**
     * 306	社区周边设施-中学	地理数据-聚客点统计
     * @param yx
     * @return
     */
    public static BigDecimal m_306(String yx){
        return poiAttraction(yx, "141202", 306);
    }

    /**
     * 307	社区周边设施-商场	地理数据-聚客点统计	商场+普通商场+购物中心
     * @param yx
     * @return
     */
    public static BigDecimal m_307(String yx){
        BigDecimal a = poiAttraction(yx, "060100", 307);
        BigDecimal b = poiAttraction(yx, "060101", 307);
        BigDecimal c = poiAttraction(yx, "060102", 307);
        return a.add(b).add(c);
    }

    /**
     * 308	网点范围内交通情况-公交站	地理数据-交通设施统计-公交站
     * @param yx
     * @return
     */
    public static BigDecimal m_308(String yx){
        return poiTransport(yx, "bus", 308);
    }

    public static BigDecimal poiTransport(String yx, String transType, int num){
        try {
            String url = "http://pre-mist-service.amap.com/mist/poi/transport?type=0&type_info=2.5&magic=1&trans_type="+transType+"&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            Integer integer = JSONObject.parseObject(s).getJSONObject("content").getJSONObject(transType).getInteger("cnt");
            if(integer!=null){
                return new BigDecimal(integer+"");
            }
        }catch (Exception e){
            
            LOGGER.error(num+"[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 309	网点范围内交通情况-地铁站	地理数据-交通设施统计-地铁站
     * @param yx
     * @return
     */
    public static BigDecimal m_309(String yx){
        return poiTransport(yx, "subway", 309);
    }

    /**
     * 310	网点范围内交通情况-停车场	地理数据-交通设施统计-停车场
     * @param yx
     * @return
     */
    public static BigDecimal m_310(String yx){
        return poiTransport(yx, "parking", 310);
    }

    /**
     * 311	行业繁荣指数	地理数据-行业POI统计
     * @param yx
     * @return
     */
    public static BigDecimal m_311(String yx){
        try {
            String tradeTypeAll = "hotel,food,bank,shop,gas,edu,sport,vehicle,hospital,school";
            String url = "http://pre-mist-service.amap.com/mist/poi/trade?type=0&type_info=2.5&magic=1&trade_type="+tradeTypeAll+"&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content");
            String[] splits = tradeTypeAll.split(",");
            BigDecimal sum = BigDecimal.ZERO;
            for (String code : splits){
                BigDecimal cnt = BigDecimal.ZERO;
                try {
                    cnt = new BigDecimal(String.valueOf(jsonObject.getInteger(code)));
                }catch (Exception e){
                    cnt = BigDecimal.ZERO;
                }
                if(cnt!=null){
                    sum = sum.add(cnt);
                }
            }
            return sum;
        }catch (Exception e){
            
            LOGGER.error("311[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }

    public static BigDecimal poiTrade(String yx, String tradeType, int num){
        try {
            String url = "http://pre-mist-service.amap.com/mist/poi/trade?type=0&type_info=2.5&magic=1&trade_type="+tradeType+"&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            Integer integer = JSONObject.parseObject(s).getJSONObject("content").getInteger(tradeType);
            if(integer!=null){
                return new BigDecimal(integer);
            }
        }catch (Exception e){
            
            LOGGER.error(num+"[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


    /**
     * 312	典型行业分布指数-餐饮业	地理数据-行业POI统计
     * @param yx
     * @return
     */
    public static BigDecimal m_312(String yx){
        return poiTrade(yx, "food", 312);
    }

    /**
     * 313	典型行业分布指数-购物	地理数据-行业POI统计
     * @param yx
     * @return
     */
    public static BigDecimal m_313(String yx){
        return poiTrade(yx, "shop", 313);
    }

    /**
     * 314	典型行业分布指数-酒店	地理数据-行业POI统计
     * @param yx
     * @return
     */
    public static BigDecimal m_314(String yx){
        return poiTrade(yx, "hotel", 314);
    }

    /**
     * 315	典型行业分布指数-体育休闲娱乐	地理数据-行业POI统计
     * @param yx
     * @return
     */
    public static BigDecimal m_315(String yx){
        return poiTrade(yx, "sport", 315);
    }

    /**
     * 316	聚客点指数-综合指数	地理数据-聚客点统计
     * @param yx
     * @return
     */
    public static BigDecimal m_316(String yx){
        try {
            String typeCodeAll = "090101,150400,150104,150200,150300,150301,150302,150303,150304,060100,060101,060102,060103,080101,141201,141202,141203,141204,141205,141206,110201,110202,110203,140300,120201,140400,140500,140600,140700,140800,130101,130102,130103,130104,130105,130106,130107,120304";
            String url = "http://pre-mist-service.amap.com/mist/poi/attraction?type=0&type_info=2.5&magic=1&typecode="+typeCodeAll+"&month=201909&yx="+yx;
            String s = HttpUtils.httpGetReq(url);
            if(StringUtils.isEmpty(s)){
                return BigDecimal.ZERO;
            }
            JSONObject jsonObject = JSONObject.parseObject(s).getJSONObject("content");
            String[] splits = typeCodeAll.split(",");
            BigDecimal sum = BigDecimal.ZERO;
            for (String code : splits){
                BigDecimal cnt = BigDecimal.ZERO;
                try {
                    cnt = new BigDecimal(String.valueOf(jsonObject.getJSONObject(code).getInteger("cnt")));
                }catch (Exception e){
                    cnt = BigDecimal.ZERO;
                }
                if(cnt!=null){
                    sum = sum.add(cnt);
                }
            }
            return sum;
        }catch (Exception e){
            
            LOGGER.error("316[E] yx={}", yx);
        }
        return BigDecimal.ZERO;
    }


}
