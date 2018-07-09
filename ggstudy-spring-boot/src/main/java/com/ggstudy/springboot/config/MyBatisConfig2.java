package com.ggstudy.springboot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.ggstudy.springboot.mapper.db2", sqlSessionFactoryRef = "sqlSessionFactory2")
public class MyBatisConfig2{

	@Autowired
	@Qualifier("ds2")
	DataSource ds2;

	@Bean(name = "sqlSessionFactory2")
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(ds2);
		return factoryBean.getObject();
	}

	@Bean(name = "sqlSessionTemplate2")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory2) {
		return new SqlSessionTemplate(sqlSessionFactory2);
	}

	@Bean(name="transactionManager2")
	public PlatformTransactionManager transactionManager2() {
		return new DataSourceTransactionManager(ds2);
	}
}