package com.pipipark.j.mvc.bean;

import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.pipipark.j.mvc.PPPMvcPostProcessor;
import com.pipipark.j.mvc.scaner.PPPPostProcessorScaner;
import com.pipipark.j.system.classscan.v2.PPPScanerManager;
import com.pipipark.j.system.core.PPPLogger;
import com.pipipark.j.system.core.PPPString;


public class PPPBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//root application context.
		if(event.getApplicationContext().getParent() == null){
			PPPLogger.systemInfo("SpringBean initializer end and Post processor start");
			PPPPostProcessorScaner scaner = (PPPPostProcessorScaner)PPPScanerManager.scaner(PPPString.lowFirst(PPPString.className(PPPPostProcessorScaner.class)));
			Set<?> set = scaner.data();
			for (Object post : set) {
				PPPLogger.info("post class: "+post.getClass().getName());
				PPPMvcPostProcessor pp = (PPPMvcPostProcessor)post;
				pp.handler();
			}
			PPPLogger.systemInfo("Post processor end");
		}
	}

}
