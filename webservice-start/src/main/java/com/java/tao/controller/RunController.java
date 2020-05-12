package com.java.tao.controller;

import com.java.tao.bean.UserProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName
 *
 * @author zewen.wang
 * @date 2020/4/16
 */
@RestController
public class RunController {

    @Resource
    private UserProperties userProperties;

    @RequestMapping("/run/hello")
    public String run(){
        return userProperties.getName()+"|"+userProperties.getAge();
    }

}
