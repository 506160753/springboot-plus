package com.example.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019/11/12 15:20
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot 2.0!";
    }

}
