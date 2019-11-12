package com.java.tao.controller;

import com.java.tao.rabbitmq.springboot.config.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rabbitmq")
public class RabbitmqController {

    @Autowired
    @Qualifier("rabbitProvider")
    private Provider provider;

    @RequestMapping("/send")
    @ResponseBody
    public String sendMsg(@RequestParam(name = "message") String message){
        provider.sendEmail(message);
        provider.sendSms(message);
        provider.sendBoth(message);
        return "success";
    }
}
