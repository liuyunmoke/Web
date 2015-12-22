package com.pipipark.j.mvc.server;

import java.util.List;

import com.pipipark.j.mvc.core.PPPSpring;
import com.pipipark.j.mvc.server.scaner.PPPServiceScaner;
import com.pipipark.j.system.annotation.PPPIndex;
import com.pipipark.j.system.classscan.v2.PPPScanerManager;
import com.pipipark.j.system.core.PPPConstant;
import com.pipipark.j.system.core.PPPLogger;
import com.pipipark.j.system.core.PPPString;

@SuppressWarnings("serial")
@PPPIndex(PPPConstant.Indexs.HIGHEST_INDEX)
public class ServerServiceRegisterPostProcessor implements PPPServerPostProcessor {

	@Override
	public void handler() {
		PPPServiceScaner scaner = (PPPServiceScaner)PPPScanerManager.scaner(PPPString.lowFirst(PPPString.className(PPPServiceScaner.class)));
		List<Class<?>> set = scaner.types();
		for (Class<?> bean : set) {
			PPPLogger.info("register service: "+bean.getName()+" ["+bean.hashCode()+"]");
			PPPSpring.addBean(bean);
		}
	}
}
