package com.java.tao.answer.a.session_transacted;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {

    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
        Destination destination = session.createQueue("session_queue");
        MessageConsumer consumer = session.createConsumer(destination);
        TextMessage receive = (TextMessage)consumer.receive(1000);
            System.out.println(receive.getText());
            session.commit();
        session.close();
        connection.close();
    }
}
