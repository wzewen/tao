package com.java.tao.rabbitmq.base.b.publish_subscribe;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    private static String exchange = "test_pub_sub_exchange";
    private static String email = "test_pub_sub_queue_email";
    private static String sms = "test_pub_sub_queue_sms";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchange, BuiltinExchangeType.FANOUT);
        channel.queueDeclare(email, true, false, false, null);
        channel.queueDeclare(sms, true, false, false, null);
        channel.queueBind(email, exchange, "");
        channel.queueBind(sms, exchange, "");
        for (int i=0; i<10; i++){
            String message = i+" test pub sub exchange : "+System.currentTimeMillis();
            channel.basicPublish(exchange, "", null, message.getBytes());
        }
        System.out.println("sender message end.");
        channel.close();
        connection.close();

    }
}
