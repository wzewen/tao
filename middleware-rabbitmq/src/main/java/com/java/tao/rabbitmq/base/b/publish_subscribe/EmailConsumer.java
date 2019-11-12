package com.java.tao.rabbitmq.base.b.publish_subscribe;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

public class EmailConsumer {
    private static String exchange = "test_pub_sub_exchange";
    private static String email = "test_pub_sub_queue_email";

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
        channel.queueDeclare(email, true, false, false ,null);
        channel.queueBind(email, exchange, "");
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws UnsupportedEncodingException {
                System.out.println("****** email consumer receiver message ******");
                System.out.println("consumerTag : "+consumerTag);
                //交换机
                System.out.println("exchange : "+envelope.getExchange());
                //路由
                System.out.println("routing : "+envelope.getRoutingKey());
                //消息id
                System.out.println("deliveryTag : "+envelope.getDeliveryTag());
                //properties
                System.out.println("properties : "+ JSONObject.toJSONString(properties));
                //消息内容
                String msg = new String(body, "utf-8");
                System.out.println("message : "+msg);
            }
        };
        channel.basicConsume(email, true, "", consumer);

    }

}
