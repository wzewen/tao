package com.java.tao.rabbitmq.base.c.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    private static String exchange = "test_routing_exchange";
    private static String email = "test_routing_email";
    private static String sms = "test_routing_sms";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT);
        channel.queueDeclare(email, true, false, false, null);
        channel.queueDeclare(sms, true, false, false, null);
        channel.queueBind(email, exchange, email);
        channel.queueBind(sms, exchange, sms);
        for (int i=0;i<5;i++){
            String msgE = i+" test routing email : "+System.currentTimeMillis();
            channel.basicPublish(exchange, email, null, msgE.getBytes());
            String msgS = i+" test routing sms : "+System.currentTimeMillis();
            channel.basicPublish(exchange, sms, null, msgE.getBytes());
        }
        System.out.println("routing send end.");
        channel.close();
        connection.close();
    }

}
