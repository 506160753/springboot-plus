package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Author: ynz
 * @Date: 2019/1/26/026 11:52
 * @Version 1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "group2",
        consumeMode = ConsumeMode.CONCURRENTLY,messageModel=MessageModel.CLUSTERING,
        selectorExpression="tag1",selectorType = SelectorType.TAG)
public class ConsumerListener implements RocketMQListener<String> {
    public void onMessage(String message) {
        log.info("received message: {}", message);
       // throw new IllegalStateException();
    }
}
