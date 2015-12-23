package com.pipipark.j.mvc.server.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.pipipark.j.system.IPPPark;
import com.pipipark.j.system.entity.PPPEntity;

@SuppressWarnings("serial")
@Service("SpringMvcServiceHandler")
public class SpringMvcServiceHandler extends PPPEntity implements IPPPark {

	public String access(String serviceName, Integer ver, HttpServletRequest request, HttpServletResponse response){
		System.out.println("d");
		return null;
	}

	@Override
	public void desc(StringBuilder string) throws Exception {
		
	}
}
