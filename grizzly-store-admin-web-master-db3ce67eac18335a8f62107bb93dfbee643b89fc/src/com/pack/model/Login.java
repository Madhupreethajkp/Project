package com.pack.model;

public class Login {
private int userid;
private String password;
private int count;
private String username;
private String office;
private String designation;
public Login() {
	
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}

public int getUserid() {
	return userid;
}

public Login(int userid, String password) {
	super();
	this.userid = userid;
	this.password = password;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getOffice() {
	return office;
}
public void setOffice(String office) {
	this.office = office;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
}
