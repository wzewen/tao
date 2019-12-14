package com.java.tao.rabbitmq.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "rabbitProvider")
public class Provider {
    private static final Logger LOGGER = LoggerFactory.getLogger(Provider.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static String emailRoute = "springboot.email.s";
    public static String smsRoute = "springboot.sms";
    public static String bothRoute = "springboot.email.sms";

    /**
     * 发送到email
     * @param message
     */
    public void sendEmail(String message){
        rabbitTemplate.convertAndSend(emailRoute, message);
        LOGGER.info("send email message : "+message);
    }

    /**
     * 发送到sms
     * @param message
     */
    public void sendSms(String message){
        rabbitTemplate.convertAndSend(RabbitConf.EXCHANGE_NAME, smsRoute, message);
        LOGGER.info("send sms message : "+message);
    }

    /**
     * 发送给两者
     * @param message
     */
    public void sendBoth(String message){
        rabbitTemplate.convertAndSend(RabbitConf.EXCHANGE_NAME, bothRoute, message);
        LOGGER.info("send email and sms message : "+message);
    }

}
