package com.pipipark.j.mvc.server.post;

import java.util.List;

import com.pipipark.j.mvc.PPPMvcPostProcessor;
import com.pipipark.j.mvc.core.PPPContext;
import com.pipipark.j.mvc.scaner.PPPServiceScaner;
import com.pipipark.j.system.annotation.PPPIndex;
import com.pipipark.j.system.classscan.v2.PPPScanerManager;
import com.pipipark.j.system.core.PPPLogger;
import com.pipipark.j.system.core.PPPString;

@SuppressWarnings("serial")
@PPPIndex(1)
public class ServiceRegisterPostProcessor implements PPPMvcPostProcessor {

	@Override
	public void handler() {
		PPPServiceScaner scaner = (PPPServiceScaner)PPPScanerManager.scaner(PPPString.lowFirst(PPPString.className(PPPServiceScaner.class)));
		List<Class<?>> set = scaner.list();
		for (Class<?> bean : set) {
			PPPLogger.info("register service: "+bean.getClass().getName()+" ["+bean.hashCode()+"]");
			PPPContext.Spring.addBean(bean);
		}
	}
}
