package com.pipipark.j.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pipipark.j.account.service.LoginService;
import com.pipipark.j.account.service.Register2Service;
import com.pipipark.j.account.service.RegisterService;
import com.pipipark.j.mvc.core.PPPContext;
import com.pipipark.j.system.core.PPPObject;

@Controller
public class TestContoller {

	
	@RequestMapping("/test")
	public void test(){
		RegisterService s1 = (RegisterService)PPPContext.Spring.getBean("registerService");
//		Object l= PPPContext.Spring.addBean(new LoginService());
		System.out.println(s1.hashCode());
		System.out.println(PPPContext.Spring.getBean("loginService"));
//		System.out.println(l);
	}
}
