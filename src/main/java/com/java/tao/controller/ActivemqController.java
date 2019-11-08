package com.java.tao.controller;

import com.java.tao.config.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/activemq")
public class ActivemqController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivemqController.class);
    @Autowired
    private Provider provider;

    @RequestMapping("/send")
    @ResponseBody
    public String sender(@RequestParam(name = "msg") String message){
        LOGGER.info("sender queue");
        provider.sendTestQueue("test --> "+message);
        provider.sendPreQueue("pre --> "+message);
        LOGGER.info("sender topic");
        provider.sendTopic(message);
        LOGGER.info("sender end");
        return "success";
    }
}
