package com.pipipark.j.account.mouse.db;

import java.util.List;

import com.pipipark.j.database.dialect.sqlite.SqliteDB;
import com.pipipark.j.database.exception.PPPSqlException;
import com.pipipark.j.database.tool.PPPRecord;
import com.pipipark.j.system.exception.PPPServiceException;

public class MySqliteDB extends SqliteDB {

	private static final long serialVersionUID = -4787359241780081214L;

	@Override
	public String dbName() {
		return "pipipark";
	}
	
	@Override
	public String dbUser() {
		return null;
	}

	@Override
	public String dbPassword() {
		return null;
	}

	public static void main(String[] args){
		MySqliteDB db = new MySqliteDB();
		try {
			db.open();
//			db.executeUpdate("insert into persons ('num',name) values (2,'alalei')");
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
		
	}
}
