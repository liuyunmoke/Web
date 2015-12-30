package com.pipipark.j.account.mouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pipipark.j.account.mouse.db.MyMysqlDB;
import com.pipipark.j.database.exception.PPPSqlException;
import com.pipipark.j.database.tool.PPPRecord;
import com.pipipark.j.system.exception.PPPServiceException;

@Service
public class LoginService {
	
	public String execute(){
		MyMysqlDB db = new MyMysqlDB();
		try {
			db.open();
			db.executeUpdate("insert into persons (num,name) values (4,'alalei3')");
			List<PPPRecord> list = db.executeQuery("select * from persons");
			System.out.println("result:");
			for (PPPRecord person : list) {
				System.out.println(person.get("id"));
			}
			db.commit();
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
}
