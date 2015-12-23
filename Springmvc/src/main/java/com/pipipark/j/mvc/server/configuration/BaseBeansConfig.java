package com.pipipark.j.mvc.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pipipark.j.mvc.core.PPPSpring;
import com.pipipark.j.mvc.server.processor.BeanAfterInitProcessor;
import com.pipipark.j.mvc.server.processor.BeanBeforeInitProcessor;


@Configuration
public class BaseBeansConfig {
	
	@Bean
	public PPPSpring springContext(){
		return new PPPSpring();
	}
	
	@Bean
	public BeanBeforeInitProcessor beanBeforeInitProcessor(){
		return new BeanBeforeInitProcessor();
	}
	
	@Bean
	public BeanAfterInitProcessor beanAfterInitProcessor(){
		return new BeanAfterInitProcessor();
	}

}
