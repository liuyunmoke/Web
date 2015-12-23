package com.pipipark.j.account.mouse;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pipipark.j.account.mouse.service.LoginService;
import com.pipipark.j.account.mouse.service.LogoutService;
import com.pipipark.j.account.mouse.service.RegisterService;
import com.pipipark.j.mvc.core.PPPSpring;

@Controller
public class TestContoller {
	
//	@Resource
//	private RegisterService registerService;
//	
//	@Resource
//	private LogoutService logoutService;
//	
//	@Resource
//	private LoginService loginService;
	
	@RequestMapping("/test")
	public void test(){
		Object bean = PPPSpring.getBean("registerService");
		System.out.println(bean);
//		loginService.execute();
	}
}
