package com.java.tao.rabbitmq.base.a.work_queues;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

public class Consumer {

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
         * 声明队列
         * params1：队列名称
         * params2：是否持久化
         * params3：队列是否独占此连接
         * params4：队列不再使用时是否删除
         * params5：队列参数
         */
        channel.queueDeclare("test_queue_works", true, false, false, null);
        /**
         * 创建消费对象
         */
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            /**
             * @param consumerTag 消费者的标签，在channel.basicConsume()去指定
             * @param envelope 消息包的内容，可从中获取消息id，消息routingkey，交换机，消息和重传标志
             * (收到消息失败后是否需要重新发送)
             * @param properties
             * @param body
             * @throws UnsupportedEncodingException
             */
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws UnsupportedEncodingException {
                System.out.println("****** consumer receiver message ******");
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
        /**
         * 监听队列
         * params1：队列名称
         * params2：是否自动回复，设置为true为表示消息接收到自动向mq回复接收到了，mq接收到回复会删除消息，设置
         * 为false则需要手动回复
         * params3：消费方法
         */
        channel.basicConsume("test_queue_works", true, "tag"+System.currentTimeMillis(), consumer);
    }
}
