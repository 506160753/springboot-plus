package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuxing
 * @version 1.0
 * @date 2019/12/31 11:40
 */
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/check")
    private String check() {
        logger.info("health check");
        return "ok";
    }

    @GetMapping("/hello")
    public String hello() {
        logger.info("hello");
        return "hello from server provider";
    }
}
