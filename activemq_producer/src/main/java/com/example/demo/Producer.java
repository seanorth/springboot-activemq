package com.example.demo;

/**
 * 生产者
 *
 * @author zhanfei
 * @create 2017/9/22
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    private static int count= 0;

    /**
     * 每5S执行一次
     */
    //@Scheduled注解为定时任务
    @Scheduled(fixedRate = 5000, initialDelay = 3000)
    public void send() {
        //发送队列消息
        this.jmsMessagingTemplate.convertAndSend(this.queue, "生产者辛苦生产的点对点消息成果"+count);
        System.out.println("生产者：辛苦生产的点对点消息成果"+count);
        //发送订阅消息
        this.jmsMessagingTemplate.convertAndSend(this.topic, "生产者辛苦生产的订阅/发布消息成果"+count++);
        System.out.println("生产者：辛苦生产的订阅/发布消息成果"+count);
    }
}
