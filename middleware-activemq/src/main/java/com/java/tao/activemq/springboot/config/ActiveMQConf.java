package com.java.tao.activemq.springboot.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMQConf {

    /**
     * 两个点对点模式bean
     * @return
     */
    @Bean(name = "testQueue")
    public Queue testQueue(){
        return new ActiveMQQueue("test_queue");
    }
    @Bean(name = "preQueue")
    public Queue preQueue() {
        return new ActiveMQQueue("pre_queue");
    }

    /**
     * 一个发布/订阅模式bean
     * @return
     */
    @Bean
    public Topic topic(){
        return new ActiveMQTopic("test_topic");
    }

    /**
     * 消息重发机制
     * @return
     */
//    @Bean
//    public RedeliveryPolicy testQueueRedeliveryPolicy(){
//        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
//        //是否在每次失败重发时，增长等待时间
//        redeliveryPolicy.setUseExponentialBackOff(true);
//        //设置重发最大拖延时间，-1表示没有拖延，只有setUseExponentialBackOff(true)时生效
//        redeliveryPolicy.setMaximumRedeliveryDelay(-1);
//        //重发次数，默认为6
//        redeliveryPolicy.setMaximumRedeliveries(6);
//        //重发时间间隔，默认1s
//        redeliveryPolicy.setInitialRedeliveryDelay(1);
//        //第一次失败后重发前等待500毫秒，第二次500*2，依次递增
//        redeliveryPolicy.setBackOffMultiplier(2);
//        //是否避免消息碰撞
//        redeliveryPolicy.setUseCollisionAvoidance(false);
//        return redeliveryPolicy;
//    }

    /**
     * 连接工厂对象
     * @return
     */
    @Bean("connectionFactoryQueue")
    public ActiveMQConnectionFactory connectionFactoryQueue(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        //设置重发机制
        //activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy());
        return activeMQConnectionFactory;
    }

//    @Bean
//    public JmsTemplate jmsTemplate(@Qualifier("connectionFactoryQueue") ActiveMQConnectionFactory connectionFactory){
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setDeliveryMode(2);//设置持久化，1 非持久， 2 持久化
//        jmsTemplate.setConnectionFactory(connectionFactory);
//        jmsTemplate.setSessionAcknowledgeMode(1);//消息确认模式
//        return jmsTemplate;
//    }

    /**
     * 点对点模式监听工厂bean
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory jmsListenerContainerQueue(@Qualifier("connectionFactoryQueue") ActiveMQConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setPubSubDomain(false);//队列模式
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        defaultJmsListenerContainerFactory.setConcurrency("1-10");//设置连接数
        defaultJmsListenerContainerFactory.setRecoveryInterval(1000L);//重连间隔时间
        defaultJmsListenerContainerFactory.setSessionAcknowledgeMode(4);
        return defaultJmsListenerContainerFactory;
    }

    /**
     * 发布/订阅模式监听工厂bean
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory jmsListenerContainerTopic(@Qualifier("connectionFactoryQueue") ActiveMQConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setPubSubDomain(true);//主题模式
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        defaultJmsListenerContainerFactory.setConcurrency("1-10");//设置连接数
        defaultJmsListenerContainerFactory.setRecoveryInterval(1000L);//重连间隔时间
        defaultJmsListenerContainerFactory.setSessionAcknowledgeMode(4);
        return defaultJmsListenerContainerFactory;
    }

}
