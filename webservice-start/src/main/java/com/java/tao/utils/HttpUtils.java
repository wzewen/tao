package com.java.tao.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    public static String httpGetReq(String url) {
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if(200==response.getStatusLine().getStatusCode()){
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, "UTF-8");
            }
            response.close();
            httpClient.close();
        }catch (Exception e){
            LOGGER.error("http get[E]", e);
        }
        return "";
    }

    public static void main(String[] args) {
        String s = httpGetReq("http://140.205.217.247/weizhi/trend?aoiid=B000A8VT15&start_date=20191011&end_date=20191011&time_type=1&flush=1&appname=amap-apimonitor");
        Object o = JSONObject.parseObject(s).getJSONObject("data").get("index_data");
        System.out.println(o.toString());
    }

}
