package com.java.tao.activemq.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component(value = "activeProvider")
public class Provider {

    /**
     * 两个队列
     */
    @Autowired
    @Qualifier("testQueue")
    private Queue testQueue;
    @Autowired
    @Qualifier("preQueue")
    private Queue preQueue;
    /**
     * 一个主题
     */
    @Autowired()
    @Qualifier("testTopic")
    private Topic topic;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendTestQueue(String message) {
        jmsTemplate.convertAndSend(testQueue, message);
    }

    public void sendPreQueue(String message) {
        jmsTemplate.convertAndSend(preQueue, message);
    }

    public void sendTopic(String message){
        jmsTemplate.convertAndSend(topic, message);
    }

}
