package com.example.demo.controller;

import com.example.demo.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxing
 * @version 1.0
 * @date 2019/12/25 12:07
 */
@RestController
public class SendMessageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
//
//    @GetMapping("/send")
//    public void send(String message) {
//        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send("test", message);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//                logger.info("成功发送消息：{}，offset=[{}]", message, result.getRecordMetadata().offset());
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//                logger.error("消息：{} 发送失败，原因：{}", message, ex.getMessage());
//            }
//        });
//    }

    @GetMapping("/send")
    public void send(String message) {
        this.kafkaTemplate.send("test",new Message("1",message));
    }
}
