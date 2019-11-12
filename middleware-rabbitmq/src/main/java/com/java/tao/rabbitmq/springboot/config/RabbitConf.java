package com.java.tao.rabbitmq.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {
    public static final String EXCHANGE_NAME = "exchange_springboot";
    public static final String QUEUE_EMAIL_NAME = "queue_email";
    public static final String QUEUE_SMS_NAME = "queue_sms";

    @Bean(EXCHANGE_NAME)
    public Exchange createExchange(){
        //durable(true)持久化，消息队列重启后交换机仍然存在
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    @Bean(QUEUE_EMAIL_NAME)
    public Queue emailQueue(){
        return new Queue(QUEUE_EMAIL_NAME);
    }

    @Bean(QUEUE_SMS_NAME)
    public Queue smsQueue(){
        return new Queue(QUEUE_SMS_NAME);
    }

    @Bean
    public Binding EMAIL_BIND_EXCHANGE(@Qualifier(QUEUE_EMAIL_NAME) Queue queue, @Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("springboot.#.email.#").noargs();
    }

    @Bean
    public Binding SMS_BIND_EXCHANGE(@Qualifier(QUEUE_SMS_NAME) Queue queue, @Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("springboot.#.sms.#").noargs();
    }

}
