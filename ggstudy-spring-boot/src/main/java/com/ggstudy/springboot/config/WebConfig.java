package com.ggstudy.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebMvc
@ComponentScan("com.ggstudy.springboot.controller")
public class WebConfig {
	
	@Bean
	public Map<String, String> getProperties() {
		Map<String, String> pp = new HashMap<String, String>();
		pp.put("A", "AA");
		pp.put("B", "BB");
		return pp;
	}
}
