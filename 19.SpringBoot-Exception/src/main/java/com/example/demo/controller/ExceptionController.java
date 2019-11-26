package com.example.demo.controller;

import com.example.demo.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/RuntimeException")
    public void RuntimeException() {
        throw new RuntimeException("有个业务异常");
    }

    @GetMapping("/BusinessException")
    public void BusinessException() {
        throw new BusinessException("有个自定义异常");
    }
}
