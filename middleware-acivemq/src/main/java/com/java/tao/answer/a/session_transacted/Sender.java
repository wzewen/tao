package com.java.tao.answer.a.session_transacted;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sender {
    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("session_queue");
        MessageProducer producer = session.createProducer(destination);
        TextMessage textMessage = session.createTextMessage("hello word !");
        producer.send(textMessage);
        session.commit();
        session.close();
        connection.close();
    }
}
