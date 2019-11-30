package com.example.mybatis;

import com.example.mybatis.properties.SystemProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.example.mybatis.mapper")
@EnableConfigurationProperties(SystemProperties.class)
public class SpringBootShiroJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShiroJwtApplication.class, args);
    }

}
