package com.pipipark.j.mvc.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pipipark.j.mvc.core.PPPSpringContext;
import com.pipipark.j.mvc.server.processor.BeanAfterInitProcessor;
import com.pipipark.j.mvc.server.processor.BeanBeforeInitProcessor;

/***
 * Bean注入配置.
 * @author pipipark:cwj
 */
@Configuration
public class BaseBeansConfig {
	
	@Bean
	public PPPSpringContext springContext(){
		return new PPPSpringContext();
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
