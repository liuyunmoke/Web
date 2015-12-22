package com.pipipark.j.mvc.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.pipipark.j.system.entity.PPPEntity;

@SuppressWarnings("serial")
@Service
public class SpringMvcServiceHandler extends PPPEntity {

	public void access(String serviceName, Integer ver, HttpServletRequest request, HttpServletResponse response){
		System.out.println("d");
	}

	@Override
	public void desc(StringBuilder string) throws Exception {
		
	}
}
