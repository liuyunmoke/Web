package com.pipipark.j.account;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pipipark.j.account.service.LoginService;
import com.pipipark.j.account.service.RegisterService;
import com.pipipark.j.mvc.core.PPPContext;

@Controller
public class TestContoller {
	
	@Resource
	private RegisterService registerService;
	
	@Resource
	private LoginService loginService;
	
	@RequestMapping("/test")
	public void test(){
		loginService.execute();
	}
}
