package com.example.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

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
@ImportResource(locations={"classpath:application-bean.xml"})
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


}
