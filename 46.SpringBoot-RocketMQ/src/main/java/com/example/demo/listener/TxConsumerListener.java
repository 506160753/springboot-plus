package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Author: ynz
 * @Date: 2019/1/26/026 11:52
 * @Version 1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "group1")
public class TxConsumerListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("received tx message: {}", message);
    }

}
