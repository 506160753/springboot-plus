package com.example.config.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "blog")
@Configuration
@Data
public class ConfigBean {

    private String name;
    private String title;
    private String wholeTitle;

}
