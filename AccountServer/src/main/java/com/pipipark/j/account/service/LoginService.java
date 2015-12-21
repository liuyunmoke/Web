package com.pipipark.j.account.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pipipark.j.mvc.PPPMvcService;

public class LoginService implements PPPMvcService {
	
	public String execute(){
		return "234";
	}
	
	@PostConstruct
	public String execute2(){
		return "1121";
	}
	
}
