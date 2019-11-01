package com.java.tao.gaode.controller;

import com.alibaba.fastjson.JSONObject;
import com.java.tao.bean.Result;
import com.java.tao.gaode.service.MatrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/matrix")
@Controller
public class MatrixController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixController.class);

    @Autowired
    private MatrixService matrixService;

    @RequestMapping("/test")
    @ResponseBody
    public List<String> test(@RequestBody Map<String, Object> body){
        String name = (String)body.get("name");
        LOGGER.info(name+" matrix test[I]");
        List<String> lons = (List)body.get("lons");
        List<String> lats = (List)body.get("lats");
        Integer rows = ObjectUtils.isEmpty(body.get("rows"))?5:(Integer)body.get("rows");
        List<String> matrix = matrixService.matrix(lats, lons, rows, name);
        LOGGER.info(name+" matrix test[O]");
        return matrix;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public List<String> test2(@RequestBody Map<String, Object> body){
        String name = (String)body.get("name");
        LOGGER.info(name+" matrix test2[I]");
        List<String> lons = (List)body.get("lons");
        List<String> lats = (List)body.get("lats");
        Integer rows = ObjectUtils.isEmpty(body.get("rows"))?5:(Integer)body.get("rows");
        List<String> matrix = matrixService.matrix2(lats, lons, rows, name);
        LOGGER.info(name+" matrix test2[O]");
        return matrix;
    }


    @RequestMapping(value = "/batchInsert", method = RequestMethod.POST)
    @ResponseBody
    public Result batchInsert(@RequestBody JSONObject body){
        try{
            String fromPoints = body.getString("from_points");
            String toPoints = body.getString("to_points");
            String[] fromList = fromPoints.split(";");
            String[] toList = toPoints.split(";");
            LOGGER.info("from_points size={}", fromList.length);
            LOGGER.info("to points size={}", toList.length);


        }catch (Exception e){
            LOGGER.error("matrix batch insert[E]", e);
            return Result.fail("service error");
        }
        return Result.success(null);
    }







}
