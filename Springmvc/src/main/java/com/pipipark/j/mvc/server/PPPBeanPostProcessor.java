package com.pipipark.j.mvc.server;

import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.pipipark.j.mvc.PPPMvcPostProcessor;
import com.pipipark.j.mvc.server.scaner.PPPPostProcessorScaner;
import com.pipipark.j.system.classscan.v2.PPPScanEntity;
import com.pipipark.j.system.classscan.v2.PPPScanerManager;
import com.pipipark.j.system.core.PPPLogger;
import com.pipipark.j.system.core.PPPString;


public class PPPBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//root application context.
		if(event.getApplicationContext().getParent() == null){
			PPPLogger.systemInfo("SpringBean initializer end and Post processor start");
			//server post
			PPPServerPostProcessorScaner serverScaner = (PPPServerPostProcessorScaner)PPPScanerManager.scaner(PPPString.lowFirst(PPPString.className(PPPServerPostProcessorScaner.class)));
			Set<PPPScanEntity> serverSet = serverScaner.getData();
			for (PPPScanEntity serverPost : serverSet) {
				PPPLogger.info("post class: "+serverPost.getType().getName());
				PPPServerPostProcessor pp = (PPPServerPostProcessor)serverPost.getTarget();
				pp.handler();
			}
			
			//service post
			PPPPostProcessorScaner scaner = (PPPPostProcessorScaner)PPPScanerManager.scaner(PPPString.lowFirst(PPPString.className(PPPPostProcessorScaner.class)));
			Set<PPPScanEntity> set = scaner.getData();
			for (PPPScanEntity post : set) {
				PPPLogger.info("post class: "+post.getType().getName());
				PPPMvcPostProcessor pp = (PPPMvcPostProcessor)post.getTarget();
				pp.handler();
			}
			PPPLogger.systemInfo("Post processor end");
		}
	}

}
