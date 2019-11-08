package com.java.tao.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sender {

    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        //创建链接
        Connection connection = connectionFactory.createConnection();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Destination destination = session.createQueue("test_queue");
        //创建消费者
        MessageProducer producer = session.createProducer(destination);
        //创建消息
        TextMessage textMessage = session.createTextMessage("hello word !");
        //发送消息
        producer.send(textMessage);
        //关闭资源
        session.close();
        connection.close();
    }
}
