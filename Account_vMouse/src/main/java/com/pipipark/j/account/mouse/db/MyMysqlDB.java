package com.pipipark.j.account.mouse.db;

import com.pipipark.j.database.dialect.mysql.MysqlDB;

@SuppressWarnings("serial")
public class MyMysqlDB extends MysqlDB {

	@Override
	public String dbName() {
		return "account";
	}

	@Override
	public String dbUser() {
		return "root";
	}

	@Override
	public String dbPassword() {
		return "123456";
	}

}
