package com.pipipark.j.mvc.server.init;

import java.util.EventListener;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import com.pipipark.j.mvc.PPPMvcInitializer;
import com.pipipark.j.mvc.scaner.PPPListenerScaner;
import com.pipipark.j.system.classscan.v2.PPPScanerManager;
import com.pipipark.j.system.core.PPPLogger;
import com.pipipark.j.system.core.PPPString;

@SuppressWarnings("serial")
@Order(4)
public class ListenerInitializer implements WebApplicationInitializer,PPPMvcInitializer {

	@SuppressWarnings("unchecked")
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		PPPLogger.systemInfo("Listener initializer");
		
		//扫描项目中所有监听器
		PPPListenerScaner scaner = (PPPListenerScaner)PPPScanerManager.scaner(PPPString.lowFirst(PPPString.className(PPPListenerScaner.class)));
		Set<EventListener> set = (Set<EventListener>)scaner.data();
		
		for (EventListener listener : set) {
			servletContext.addListener(listener);
		}
	}

}
