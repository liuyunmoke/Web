package com.pipipark.j.mvc.server.scaner.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pipipark.j.mvc.PPPMvcInterceptor;
import com.pipipark.j.system.annotation.PPPIndex;
import com.pipipark.j.system.core.PPPLogger;


@SuppressWarnings("serial")
@PPPIndex(50)
public class LogerInterceptor implements PPPMvcInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		PPPLogger.debug(request.getRequestURI());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
