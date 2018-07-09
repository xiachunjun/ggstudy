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

import com.ggstudy.springboot.support.BeanAnnotationTest;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.ggstudy.springboot.mapper.db1", sqlSessionFactoryRef = "sqlSessionFactory1")
public class MyBatisConfig1 {// 实现接口
								// TransactionManagementConfigurer
								// 方法，其返回值代表在拥有多个事务管理器的情况下默认使用

	@Autowired
	@Qualifier("ds1")
	private DataSource ds1;
	@Autowired
	@Qualifier("beanAnnotationTest")
	private BeanAnnotationTest beanAnnotationTest;
	
	@Bean(name = "sqlSessionFactory1")
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		System.out.println(beanAnnotationTest);
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(ds1);
		return factoryBean.getObject();
		
	}

	@Bean(name = "sqlSessionTemplate1")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory1) {
		return new SqlSessionTemplate(sqlSessionFactory1);
	}

	@Bean(name = "transactionManager1")
	public PlatformTransactionManager transactionManager1() {
		return new DataSourceTransactionManager(ds1);
	}

}