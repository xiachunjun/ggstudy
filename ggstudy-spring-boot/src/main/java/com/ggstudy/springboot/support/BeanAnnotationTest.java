package com.ggstudy.springboot.support;

/**
 * @author xcj </br>
 *         用来测试@Bean注解配合@ConfigurationProperties的使用
 */
public class BeanAnnotationTest {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
