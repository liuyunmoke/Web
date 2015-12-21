package com.pipipark.j.mvc.server.scaner.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class DataSourceConfig {
	
}
