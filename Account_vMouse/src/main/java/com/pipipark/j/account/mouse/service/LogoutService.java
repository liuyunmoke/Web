package com.pipipark.j.account.mouse.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pipipark.j.mvc.core.PPPContext;


@Service
public class LogoutService {
	
	
	public String execute(){
		return PPPContext.properties("db.name");
	}
	
}
