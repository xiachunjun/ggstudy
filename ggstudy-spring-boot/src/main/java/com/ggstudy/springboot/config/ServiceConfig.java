package com.ggstudy.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.ggstudy.springboot.service","com.ggstudy.springboot.dao"})
public class ServiceConfig {

}
