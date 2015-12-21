package com.pipipark.j.account.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.pipipark.j.mvc.PPPMvcService;


@SuppressWarnings("serial")
public class RegisterService implements PPPMvcService {
	
	@Resource
	private LoginService loginService;
	
	@Resource
	private Register2Service register2Service;

	public String execute(){
//		return register2Service.execute();
		return "";
	}
	
	public String execute2(){
		return "1111";
	}
}
