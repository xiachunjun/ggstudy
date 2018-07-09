package com.ggstudy.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ggstudy.starter.model.ConfigClient;

@Configuration
public class AutoStarter {

	@Bean
	public ConfigClient getConfigClient() {
		ConfigClient cc = new ConfigClient();
		cc.setClientName("starter-mod");
		return cc;
	}
}
