package com.example.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatis.mapper")
public class SpringBootSecurityValidateCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityValidateCodeApplication.class, args);
    }

}