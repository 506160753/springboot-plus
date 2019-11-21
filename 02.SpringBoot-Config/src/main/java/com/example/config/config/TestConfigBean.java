package com.example.config.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:test.properties")
@Data
public class TestConfigBean {

    private String name;
    private int age;

}
