package com.pipipark.j.account.mouse.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.pipipark.j.mvc.PPPMvcService;


@SuppressWarnings("serial")
public class RegisterService implements PPPMvcService {
	
	@Autowired
	private LogoutService logoutService;
	
	public String execute(){
		return "";
	}
	
}
