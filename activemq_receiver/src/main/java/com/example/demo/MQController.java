package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * web层
 *
 * @author zhanfei
 * @create 2017/9/22
 */

@RestController
public class MQController {

    @Autowired
    private Producer producer;

    @RequestMapping("/send")
    public String send() {
        producer.send();
        return "send";
    }


}