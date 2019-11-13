package com.java.tao.rabbitmq.base.e.header;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Provider {
    private static String exchange = "test_header_exchange";
    private static String email = "test_header_email";
    private static String sms = "test_header_sms";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchange, BuiltinExchangeType.HEADERS);
        channel.queueDeclare(email, true, false, false, null);
        channel.queueDeclare(sms, true, false, false, null);
        Map<String, Object> headerEmail = new HashMap<String, Object>();
        headerEmail.put("head_type", "email");
        Map<String, Object> headerSms = new HashMap<String, Object>();
        headerSms.put("head_type", "sms");
        channel.queueBind(email, exchange, "", headerEmail);
        channel.queueBind(sms, exchange, "", headerSms);
        String msgE = "test header email message : "+ System.currentTimeMillis();
        AMQP.BasicProperties.Builder emailProperties = new AMQP.BasicProperties().builder();
        emailProperties.headers(headerEmail);
        channel.basicPublish(exchange, "", emailProperties.build(), msgE.getBytes());
        String msgS = "test header sms message : "+ System.currentTimeMillis();
        AMQP.BasicProperties.Builder smsProperties = new AMQP.BasicProperties.Builder();
        smsProperties.headers(headerSms);
        channel.basicPublish(exchange, "", smsProperties.build(), msgS.getBytes());
        System.out.println("test header sender end.");
        channel.close();
        connection.close();
    }
}
