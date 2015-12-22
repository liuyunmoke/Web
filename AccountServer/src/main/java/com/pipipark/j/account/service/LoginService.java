package com.pipipark.j.account.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pipipark.j.account.db.MyDB;
import com.pipipark.j.database.exception.PPPSqlException;
import com.pipipark.j.database.tool.PPPRecord;
import com.pipipark.j.mvc.PPPMvcService;
import com.pipipark.j.system.exception.PPPServiceException;

@SuppressWarnings("serial")
public class LoginService implements PPPMvcService {
	
	@Autowired
	private LogoutService logoutService;
	
	public String execute(){
		MyDB db = new MyDB();
		try {
			db.open();
			db.executeUpdate("insert into persons ('num',name) values (4,'alalei3')");
			List<PPPRecord> list = db.executeQuery("select * from persons");
			System.out.println("result:");
			for (PPPRecord person : list) {
				System.out.println(person.get("id"));
			}
		} catch (PPPServiceException e) {
			e.printStackTrace();
		} finally{
			try {
				db.close();
			} catch (PPPSqlException e) {
				e.printStackTrace();
			}
		}
		return "234";
	}
	
	@PostConstruct
	public String execute2(){
		return "1121";
	}
	
}
