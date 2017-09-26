package com.example.demo;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 定义队列||主题
 *
 * @author zhanfei
 * @create 2017/9/22
 */
//@Configuration相当于xml配置文件中的<beans>标签，作用是声明一个配置类 @Bean相当于<bean>标签，等价于注入一个实例
//MQ configuration class
@Configuration
public class ActiveMQConfiguration {
    /**
     * 定义点对点队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }

    /**
     * 定义一个主题
     *
     * @return
     */
    @Bean
    Topic topic() {
        return new ActiveMQTopic("sample.topic");
    }
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
    }
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

}
