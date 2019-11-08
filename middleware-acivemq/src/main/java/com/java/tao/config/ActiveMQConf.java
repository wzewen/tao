package com.java.tao.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
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
     * 连接工厂对象
     * @return
     */
    @Bean("connectionFactoryQueue")
    public ActiveMQConnectionFactory connectionFactoryQueue(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        //设置重发机制
        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy());
        return activeMQConnectionFactory;
    }

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
        return defaultJmsListenerContainerFactory;
    }

    /**
     * 消息重发机制
     * @return
     */
    @Bean
    public RedeliveryPolicy redeliveryPolicy(){
        RedeliveryPolicy redeliveryPolicy=   new RedeliveryPolicy();
        //是否在每次尝试重新发送失败后,增长这个等待时间
        redeliveryPolicy.setUseExponentialBackOff(true);
        //重发次数,默认为6次   这里设置为10次
        redeliveryPolicy.setMaximumRedeliveries(10);
        //重发时间间隔,默认为1秒
        redeliveryPolicy.setInitialRedeliveryDelay(1);
        //第一次失败后重新发送之前等待500毫秒,第二次失败再等待500 * 2毫秒,这里的2就是value
        redeliveryPolicy.setBackOffMultiplier(2);
        //是否避免消息碰撞
        redeliveryPolicy.setUseCollisionAvoidance(false);
        //设置重发最大拖延时间-1 表示没有拖延只有UseExponentialBackOff(true)为true时生效
        redeliveryPolicy.setMaximumRedeliveryDelay(-1);
        return redeliveryPolicy;
    }

}
