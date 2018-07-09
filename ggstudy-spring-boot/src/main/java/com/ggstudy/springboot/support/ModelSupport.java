package com.ggstudy.springboot.support;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelSupport {

	@Bean
	public Map<String, String> qwe() {
		Map<String, String> KVMap = new HashMap<String, String>();
		KVMap.put("key", "value1");
		return KVMap;
	}
	
	@Bean
	public Map<String, String> wewewm1() {
		Map<String, String> KVMap = new HashMap<String, String>();
		KVMap.put("key", "value");
		return KVMap;
	}
}
