package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @GetMapping("/sync")
    public void testSync() {
        long start = System.currentTimeMillis();
        logger.info("同步方法开始");

        testService.syncMethod();

        logger.info("同步方法结束");
        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
    }

    @GetMapping("/async")
    public String testAsync() throws Exception {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");

        testService.asyncMethod();

        logger.info("异步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
        return "success";
    }

    @GetMapping("/asyncExecutor")
    public String testAsyncExecutor() throws Exception {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");

        testService.asyncExecutorMethod();

        logger.info("异步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
        return "success";
    }

    @GetMapping("/asyncExecutorMethod")
    public String asyncExecutorMethod() throws Exception {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");

        Future<String> stringFuture = testService.asyncExecutorFutureMethod();
        String result = stringFuture.get(60, TimeUnit.SECONDS);
        logger.info("异步方法返回值：{}", result);

        logger.info("异步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
        return stringFuture.get();
    }

}
