package com.ggstudy.jpa.common;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configurable
@EnableWebMvc
//@EnableSpringDataWebSupport
@Import(RepositoryRestMvcConfiguration.class)
public class WebApplication {

}
