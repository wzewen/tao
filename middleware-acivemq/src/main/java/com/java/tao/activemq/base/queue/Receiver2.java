package com.java.tao.activemq.base.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Receiver2 {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("test_queue");
        MessageConsumer consumer = session.createConsumer(destination);
        while (true){
            TextMessage receive = (TextMessage)consumer.receive();
            if(receive!=null)
            System.out.println("B receiver message : "+receive.getText());
        }
    }
}
