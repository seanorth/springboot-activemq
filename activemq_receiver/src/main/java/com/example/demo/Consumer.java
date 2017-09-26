package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author zhanfei
 * @create 2017/9/22
 */
//@JmsListener注解bean 方法来注册 JMS 监听端点
@Component
public class Consumer {
    @JmsListener(destination = "sample.queue",containerFactory="jmsListenerContainerQueue")
    public void receiveQueue(String text) {
        System.out.println("消费者：来源于生产者的消息：" + text);
    }
    @JmsListener(destination = "sample.topic",containerFactory="jmsListenerContainerTopic")
    public void receiveSub1(String text) {
        System.out.println("消费者：Consumer1=" + text);
    }
    @JmsListener(destination = "sample.topic",containerFactory="jmsListenerContainerTopic")
    public void receiveSub2(String text) {
        System.out.println("消费者：Consumer2=" + text);
    }
}
