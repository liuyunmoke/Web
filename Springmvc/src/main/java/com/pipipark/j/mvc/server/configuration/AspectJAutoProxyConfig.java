package com.pipipark.j.mvc.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AspectJAutoProxyConfig {
	
}
