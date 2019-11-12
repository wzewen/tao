package com.java.tao.rabbitmq.base.d.topics;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    private static String exchange = "test_topics_exchange";
    private static String email = "test_topics_email";
    private static String sms = "test_topics_sms";
    private static String both = "test_topics_sms_email";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC);
        channel.queueDeclare(email, true, false, false, null);
        channel.queueDeclare(sms, true, false, false, null);
        String msgE = "test topic email message : "+ System.currentTimeMillis();
        String msgS = "test topic sms message : "+ System.currentTimeMillis();
        channel.basicPublish(exchange, "inform.email", null, msgE.getBytes());
        channel.basicPublish(exchange, "inform.sms", null, msgS.getBytes());
        String msgB = "test both sms message : "+ System.currentTimeMillis();
        channel.basicPublish(exchange, "inform.sms.email", null , msgB.getBytes());
        System.out.println("test topic send end.");
        channel.close();
        connection.close();
    }

}
