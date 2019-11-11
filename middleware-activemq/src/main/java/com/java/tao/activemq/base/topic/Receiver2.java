package com.java.tao.activemq.base.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Receiver2 {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic("test_topic");
        MessageConsumer consumer = session.createConsumer(destination);
        while (true){
            TextMessage receive = (TextMessage)consumer.receive();
            if(receive!=null)
                System.out.println("A receiver message : "+receive.getText());
        }
    }
}
