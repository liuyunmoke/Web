package com.pipipark.j.mvc.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***
 * Spring事务管理配置.
 * @author pipipark:cwj
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class DataSourceConfig {
	
}
