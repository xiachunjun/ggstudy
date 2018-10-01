package com.ggstudy.trans.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.ggstudy.trans.service","com.ggstudy.trans.mapper"})
public class ServiceConfig {

}
