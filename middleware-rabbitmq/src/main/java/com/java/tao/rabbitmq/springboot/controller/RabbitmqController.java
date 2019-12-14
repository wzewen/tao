package com.java.tao.rabbitmq.springboot.controller;


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
    public String send(@RequestParam(name = "message") String message){
        //provider.sendSms(message);
        provider.sendEmail(message);
       // provider.sendBoth(message);
        return "success";
    }
}
