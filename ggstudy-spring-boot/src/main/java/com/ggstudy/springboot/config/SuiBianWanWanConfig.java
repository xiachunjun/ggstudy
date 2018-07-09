package com.ggstudy.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ggstudy.springboot.support.BeanAnnotationTest;

@Component
public class SuiBianWanWanConfig {
	@Bean(name = "beanAnnotationTest")
	@ConfigurationProperties(prefix = "appConfig")
	public BeanAnnotationTest getBeanAnnotationTest() {
		Class<BeanAnnotationTest> clazz = BeanAnnotationTest.class;
		try {
			BeanAnnotationTest c = clazz.newInstance();
			return c;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
