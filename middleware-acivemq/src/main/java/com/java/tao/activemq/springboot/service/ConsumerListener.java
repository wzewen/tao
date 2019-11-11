package com.java.tao.activemq.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerListener.class);

    /**
     * 队列 test_queue 有A，B两个监听者
     * @param message
     */
    @JmsListener(destination = "test_queue", containerFactory = "jmsListenerContainerQueue")
    public void queue(String message){
        try {
            LOGGER.info("A queue message : "+message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @JmsListener(destination = "test_queue", containerFactory = "jmsListenerContainerQueue")
    public void queue2(String message){
        try {
            LOGGER.info("B queue message : "+message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 队列 pre_queue 只有一个监听者
     * @param message
     */
    @JmsListener(destination = "pre_queue", containerFactory = "jmsListenerContainerQueue")
    public void queue3(String message){
        try {
            LOGGER.info("C queue message : "+message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 主题 test_topic 有 A，B两个监听着
     * @param message
     */
    @JmsListener(destination = "test_topic", containerFactory = "jmsListenerContainerTopic")
    public void topic(String message){
        try {
            LOGGER.info("A topic message : "+message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @JmsListener(destination = "test_topic", containerFactory = "jmsListenerContainerTopic")
    public void topic2(String message){
        try {
            LOGGER.info("B topic message : "+message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
