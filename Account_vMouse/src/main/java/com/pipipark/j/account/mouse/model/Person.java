package com.pipipark.j.account.mouse.model;

import com.pipipark.j.account.mouse.db.MyMysqlDB;
import com.pipipark.j.account.mouse.db.MySqliteDB;
import com.pipipark.j.database.PPPModel;
import com.pipipark.j.database.annotation.Db;
import com.pipipark.j.database.annotation.PrimaryKey;

@Db(MyMysqlDB.class)
public class Person extends PPPModel {

	private static final long serialVersionUID = -3531909629428947002L;

	@PrimaryKey
	private Integer id;
	private String name;
	private Integer sex;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
}
