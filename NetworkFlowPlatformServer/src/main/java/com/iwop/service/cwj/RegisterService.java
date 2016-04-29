package com.iwop.service.cwj;

import com.pipipark.j.mvc.PPPMvcService;
import com.pipipark.j.mvc.core.PPPContext;
import com.pipipark.j.mvc.orm.jdbctemple.Database;
import com.pipipark.j.mvc.server.handler.servicehandler.PPPParam;



@SuppressWarnings("serial")
public class RegisterService implements PPPMvcService {
	
	public String execute(){
		Database.jdbc().update("insert into account (code,account,phone,email,password,create_time,update_time) values('111','liuyunmoke','54288','111@pipipark.com','1111',now(),now())");
		return "";
	}
	
	
	
}
