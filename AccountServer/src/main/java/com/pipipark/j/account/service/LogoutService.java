package com.pipipark.j.account.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pipipark.j.account.db.MyDB;
import com.pipipark.j.database.exception.PPPSqlException;
import com.pipipark.j.database.tool.PPPRecord;
import com.pipipark.j.mvc.PPPMvcService;
import com.pipipark.j.system.exception.PPPServiceException;

@SuppressWarnings("serial")
@Service
public class LogoutService implements PPPMvcService {
	
	public String execute(){
		return "1121111";
	}
	
	@PostConstruct
	public String execute2(){
		return "112233";
	}
	
}
