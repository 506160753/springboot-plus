package com.example.multidatasource.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = MysqlMasterDatasourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlMasterSqlSessionFactory")
public class MysqlMasterDatasourceConfig {

	// mysqldao扫描路径
	static final String PACKAGE = "com.example.multidatasource.mapper.master";
	// mybatis mapper扫描路径
//	static final String MAPPER_LOCATION = "classpath:mapper/mysql/*.xml";

	@Primary
	@Bean(name = "mysqlMasterDataSource")
	@ConfigurationProperties("spring.datasource.druid.master")
	public DataSource mysqlMasterDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlMasterTransactionManager")
	@Primary
	public DataSourceTransactionManager mysqlMasterTransactionManager() {
		return new DataSourceTransactionManager(mysqlMasterDataSource());
	}

	@Bean(name = "mysqlMasterSqlSessionFactory")
	@Primary
	public SqlSessionFactory mysqlMasterSqlSessionFactory(@Qualifier("mysqlMasterDataSource") DataSource dataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		//如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
//		sessionFactory.setMapperLocations(
//				new PathMatchingResourcePatternResolver().getResources(MysqlMasterDatasourceConfig.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}
}
