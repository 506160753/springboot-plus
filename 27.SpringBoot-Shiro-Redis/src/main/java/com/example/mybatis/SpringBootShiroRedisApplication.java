package com.example.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.example.mybatis.mapper")
public class SpringBootShiroRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShiroRedisApplication.class, args);
    }

}
