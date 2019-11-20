package com.example.config.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Data
public class BlogProperties {

	@Value("${blog.name}")
	private String name;

	@Value("${blog.title}")
	private String title;

}
