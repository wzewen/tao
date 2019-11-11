package com.java.tao.activemq.springboot.answer.a.session_transacted;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sender {
    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
        Destination destination = session.createQueue("session_queue");
        MessageProducer producer = session.createProducer(destination);
        TextMessage textMessage = session.createTextMessage("hello word !");
        //消息；   持久化；    级别；     时效
        producer.send(textMessage, DeliveryMode.PERSISTENT, 4, 1000*60*10);
        session.commit();
        session.close();
        connection.close();
    }
}
