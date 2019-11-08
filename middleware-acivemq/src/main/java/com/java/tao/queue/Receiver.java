package com.java.tao.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Receiver {

    public static void main(String[] args) throws JMSException {
        //创建链接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        //创建链接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Destination destination = session.createQueue("test_queue");
        MessageConsumer consumer = session.createConsumer(destination);
        while (true){
            TextMessage receive = (TextMessage)consumer.receive();
            if(receive!=null)
            System.out.println("A receiver message : "+receive.getText());
        }
    }
}
