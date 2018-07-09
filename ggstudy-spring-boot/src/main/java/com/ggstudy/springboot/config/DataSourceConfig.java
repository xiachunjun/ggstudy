package com.ggstudy.springboot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	/**
	 * DataSourceBuilder.create().build()方法中会去查找DataSource类型存在，本例中使用了org.apache.tomcat.jdbc.pool.DataSource，
	 * 会反射生成org.apache.tomcat.jdbc.pool.DataSource的实例，
	 * （猜想：第一步反射生成的DataSource只是一个简单实例，没有配置url、name、password等属性，因为有@ConfigurationProperties注解的存在，之后spring再对具体属性做配置）
	 * @return
	 */
	@Bean(name = "ds1")
	@ConfigurationProperties(prefix = "appConfig.db1")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "ds2")
	@ConfigurationProperties(prefix = "appConfig.db2")
	public DataSource dataSource2() {
		DataSourceBuilder dsb = DataSourceBuilder.create();
		return dsb.build();
	}


}