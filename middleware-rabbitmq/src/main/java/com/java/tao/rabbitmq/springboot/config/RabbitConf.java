package com.java.tao.rabbitmq.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RabbitConf {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitConf.class);

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

    /**
     * 连接工厂对象
     * @return
     */
    @Bean(value = "rabbitConnectionFactory")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
                "localhost",61616);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(@Qualifier("rabbitConnectionFactory") ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        //消息发送失败返回队列中，yml需要配置publisher-returns=true
//        rabbitTemplate.setMandatory(true);
//        //消息返回，yml需要配置publisher-returns=true
//        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
//            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//                String msg = message.getBody().toString();
//                LOGGER.info("send fail! message={},replyCode={},replyText={},exchange={},routingKey={}", msg, replyCode, replyText, exchange, routingKey);
//            }
//        });
        //消息确认，yml需要配置publisher-confirms=true
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                   LOGGER.info("send success. messageId={}", correlationData.getId());
                } else {
                    LOGGER.info("send fail! messageId={}", correlationData.getId());
                }
            }
        });
        return rabbitTemplate;
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
