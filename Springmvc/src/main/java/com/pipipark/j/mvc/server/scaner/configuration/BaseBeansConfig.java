package com.pipipark.j.mvc.server.scaner.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pipipark.j.mvc.core.PPPSpring;
import com.pipipark.j.mvc.server.PPPBeanPostProcessor;


@Configuration
public class BaseBeansConfig {
	
	@Bean
	public PPPSpring springContext(){
		return new PPPSpring();
	}
	
	@Bean
	public PPPBeanPostProcessor beanPostProcessor(){
		return new PPPBeanPostProcessor();
	}

}
