package com.pipipark.j.mvc.scaner.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pipipark.j.mvc.bean.PPPBeanPostProcessor;
import com.pipipark.j.mvc.core.PPPContext;


@Configuration
public class BaseBeansConfig {
	
	@Bean
	public PPPContext.Spring springContext(){
		return new PPPContext.Spring();
	}
	
	@Bean
	public PPPBeanPostProcessor beanPostProcessor(){
		return new PPPBeanPostProcessor();
	}

}
