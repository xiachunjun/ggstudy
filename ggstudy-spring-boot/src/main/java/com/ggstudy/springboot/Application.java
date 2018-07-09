package com.ggstudy.springboot;

import java.util.Arrays;
import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.ggstudy.springboot.support.EnableAnnotationTest;


@ComponentScan("com.ggstudy.springboot.config")
@EnableAnnotationTest
@EnableAsync
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application implements AsyncConfigurer {
	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(Application.class);
		sa.setAddCommandLineProperties(false);
		sa.run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("2222222222222Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

	@Bean
	public CommandLineRunner commandLineRunner2(ApplicationContext ctx) {
		return args -> {
			System.out.println("333333333333");
		};
	}

	@Bean
	public CommandLineRunner commandLineRunner1(ApplicationContext ctx) {
		return args -> {
			System.out.println("111111111111");
		};
	}

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(2);
		taskExecutor.setMaxPoolSize(5);
		taskExecutor.setQueueCapacity(50);
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}
