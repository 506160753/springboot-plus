package com.example.multidatasource.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
	@Primary
	@Bean(name = "masterdatasource")
	@ConfigurationProperties("spring.datasource.druid.master")
	public DataSource dataSourceOne(){
	    return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "slavedatasource")
	@ConfigurationProperties("spring.datasource.druid.slave")
	public DataSource dataSourceTwo(){
	    return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "masterJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(
	        @Qualifier("masterdatasource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}

	@Bean(name = "slaveJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(
	        @Qualifier("slavedatasource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
}
