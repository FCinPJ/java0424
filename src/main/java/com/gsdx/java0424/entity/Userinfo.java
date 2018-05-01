package com.gsdx.java0424.entity;

public class Userinfo {
	private int userid;
	private String username;
	private String password;
	private String realname;
	
	public Userinfo() {
		super();
	}
	public Userinfo(int userid, String username, String password, String realname) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.realname = realname;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	

}
