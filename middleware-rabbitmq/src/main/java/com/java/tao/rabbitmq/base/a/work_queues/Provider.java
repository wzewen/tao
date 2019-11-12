package com.java.tao.rabbitmq.base.a.work_queues;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        //创建连接
        Connection connection = connectionFactory.newConnection();
        //创建通道
        Channel channel = connection.createChannel();
        /**
         * 声明队列，如果没有则自动创建
         * params1：队列名称
         * params2：是否持久化
         * params3：队列是否独占此连接
         * params4：队列不在乎使用时，是否删除
         * params5：队列参数
         */
        channel.queueDeclare("test_queue_works", true, false, false, null);
        String message = "test queue works --> "+System.currentTimeMillis();
        /**
         * 发送消息
         * params1：交换机名称（不填使用默认交换机）
         * params2：队列名称
         * params3：消息包含的属性
         * params4：消息内容
         */
        channel.basicPublish("", "test_queue_works", null, message.getBytes());
        System.out.println("send message : "+message);
        //关闭资源
        channel.close();
        connection.close();
    }
}
