package com.pipipark.j.mvc.server.processor;

import java.util.List;

import com.pipipark.j.mvc.core.PPPSpring;
import com.pipipark.j.mvc.server.scaner.PPPServiceScaner;
import com.pipipark.j.system.annotation.PPPIndex;
import com.pipipark.j.system.classscan.v2.PPPScanEntity;
import com.pipipark.j.system.classscan.v2.PPPScanerManager;
import com.pipipark.j.system.core.PPPConstant;
import com.pipipark.j.system.core.PPPLogger;
import com.pipipark.j.system.core.PPPString;

/***
 * 服务注册处理器,
 * 载入并注册为SpringBean.
 * @author pipipark:cwj
 */
@SuppressWarnings("serial")
@PPPIndex(PPPConstant.Indexs.HIGHEST_INDEX)
public class ServerServiceRegisterPostProcessor implements PPPServerPostProcessor {

	@Override
	public void handler() {
		PPPServiceScaner scaner = (PPPServiceScaner)PPPScanerManager.scaner(PPPString.lowFirst(PPPString.className(PPPServiceScaner.class)));
		List<PPPScanEntity> set = scaner.list();
		for (PPPScanEntity entity : set) {
			PPPLogger.info("register service: "+entity.getType().getName()+" ["+entity.getName()+"]");
			PPPSpring.addBean(PPPString.md5(entity.getName()), entity.getType());
		}
	}
}
