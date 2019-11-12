package com.java.tao.rabbitmq.springboot.service;

import com.java.tao.rabbitmq.springboot.config.RabbitConf;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListenerService.class);

    @RabbitListener(queues = RabbitConf.QUEUE_EMAIL_NAME)
    public void emailListener(String msg, Message message, Channel channel){
        LOGGER.info("email listener message : "+msg);
    }

    @RabbitListener(queues = RabbitConf.QUEUE_SMS_NAME)
    public void smsListener(String msg, Message message, Channel channel){
        LOGGER.info("sms listener message : "+msg);
    }
}
