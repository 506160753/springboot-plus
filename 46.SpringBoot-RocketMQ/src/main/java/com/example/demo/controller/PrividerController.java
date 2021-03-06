package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.listener.TxTransactionListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PrividerController {

    @Autowired
    private DefaultMQProducer defaultProducer;

    @Autowired
    private TransactionMQProducer transactionMQProducer;

    @Autowired
    private TxTransactionListener txTransactionListener;


    @GetMapping("/test")
    public void test(String info) throws Exception {
        Message message = new Message("TopicTest", "Tag1", "12345", "rocketmq测试成功".getBytes());
        // 这里用到了这个mq的异步处理，类似ajax，可以得到发送到mq的情况，并做相应的处理
        //不过要注意的是这个是异步的
        defaultProducer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("传输成功");
                log.info(JSON.toJSONString(sendResult));
            }

            @Override
            public void onException(Throwable e) {
                log.error("传输失败", e);
            }
        });
    }

    @GetMapping("/tx")
    public void tx(String info) throws Exception {
        Message message = new Message("TopicTest", "Tag1", "12345", "tx测试成功".getBytes());
        // 这里用到了这个mq的异步处理，类似ajax，可以得到发送到mq的情况，并做相应的处理
        //不过要注意的是这个是异步的
        transactionMQProducer.setTransactionListener(txTransactionListener);
        transactionMQProducer.sendMessageInTransaction(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("传输成功");
                log.info(JSON.toJSONString(sendResult));
            }

            @Override
            public void onException(Throwable e) {
                log.error("传输失败", e);
            }
        });
    }


    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/send/{topic}/{msg}")
    public String send(@PathVariable String topic,@PathVariable String msg){
        rocketMQTemplate.convertAndSend(topic+":tag1", msg+":tag1");
        for (int i = 0; i < 1; i++) {
            rocketMQTemplate.asyncSendOrderly(topic, msg+i,String.valueOf(1),new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("传输成功");
                    log.info(JSON.toJSONString(sendResult));
                }
                @Override
                public void onException(Throwable e) {
                    log.error("传输失败", e);
                }
            });
        }
        return "send";
    }

    @RequestMapping("/sendtx/{topic}/{msg}")
    public String sendTx(@PathVariable String topic,@PathVariable String msg) throws InterruptedException {
        org.springframework.messaging.Message message =  MessageBuilder.withPayload(msg).build();
        System.out.println(Thread.currentThread().getName());

        TransactionSendResult result = rocketMQTemplate.sendMessageInTransaction("group1", topic, message,"test");

        System.out.println(result.getTransactionId());

        return "sendtx";
    }


//    @Resource
//    private RocketMQTemplate rocketMQTemplate;
//
//    @RequestMapping("/send/{topic}/{msg}")
//    public String send(@PathVariable String topic,@PathVariable String msg){
//        rocketMQTemplate.convertAndSend(topic+":tag1", msg+":tag1");
//
//        for (int i = 0; i < 1; i++) {
//            rocketMQTemplate.asyncSendOrderly(topic, msg+i,String.valueOf(1),new SendCallback() {
//                @Override
//                public void onSuccess(SendResult sendResult) {
//                    log.info("传输成功");
//                    log.info(JSON.toJSONString(sendResult));
//                }
//                @Override
//                public void onException(Throwable e) {
//                    log.error("传输失败", e);
//                }
//            });
//        }
//
//
//        // rocketMQTemplate.
//
//
//        return "send";
//    }
//
//    @RequestMapping("/sendtx/{topic}/{msg}")
//    public String sendTx(@PathVariable String topic,@PathVariable String msg) throws InterruptedException {
//        Message message =  MessageBuilder.withPayload(msg).build();
//        System.out.println(Thread.currentThread().getName());
//
//        TransactionSendResult result = rocketMQTemplate.sendMessageInTransaction("group1", topic, message,"test");
//
//        System.out.println(result.getTransactionId());
//
//        return "sendtx";
//    }

}
