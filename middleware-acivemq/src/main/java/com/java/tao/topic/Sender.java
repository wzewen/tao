package com.java.tao.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sender {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic("test_topic");
        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("hello topic mq");
        producer.send(message);
        session.close();
        connection.close();
    }
}
