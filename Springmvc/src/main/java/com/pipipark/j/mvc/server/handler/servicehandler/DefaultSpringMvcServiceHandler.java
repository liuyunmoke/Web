package com.pipipark.j.mvc.server.handler.servicehandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pipipark.j.mvc.core.PPPResonpse;
import com.pipipark.j.mvc.core.PPPSpringContext;
import com.pipipark.j.mvc.core.PPPSpringmvcConstant;
import com.pipipark.j.system.core.PPPLogger;
import com.pipipark.j.system.core.PPPVersion;

@SuppressWarnings("serial")
public class DefaultSpringMvcServiceHandler extends AbsSpringMvcServiceHandler {

	public PPPResonpse access(final String serviceName, final PPPVersion ver, HttpServletRequest request, HttpServletResponse response){
		//获取service服务
		Object service = this.getService(serviceName);
		Object returnObject = null;
		if(service==null){
			service = PPPSpringContext.getBean(serviceName);
		}
		for (Method method : service.getClass().getDeclaredMethods()) {
			if(method.getName().equals(PPPSpringmvcConstant.EXECUTE_METHOD)){
				try {
					returnObject = method.invoke(service);
					break;
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					PPPLogger.error("Your service method no found.", e);
				}
			}
		};
		PPPResonpse res = new PPPResonpse();
		res.setData(returnObject);
		return res;
	}

	@Override
	public void desc(StringBuilder string) throws Exception {
		string.append("this is default ServiceHandler, if you not have custom ServiceHandler, will be running it.");
	}
}
