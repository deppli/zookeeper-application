package org.zk.application.core.distconfigure.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class User {
	private int id;
	
	private String email;
	
	private String loginPasswd;
	
	private String MD5;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginPasswd() {
		return loginPasswd;
	}

	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd;
	}

	public String getMD5() {
		return MD5;
	}

	public void setMD5(String mD5) {
		MD5 = mD5;
	}
	
	
	
}
