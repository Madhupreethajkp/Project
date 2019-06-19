package com.pack.form;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user", schema="project")

public class User {
@NotNull
@NotEmpty
private String fname;
@NotNull
@NotEmpty
private String lname;
public User(String fname, String lname, Integer age, Gender gender, String contactNo, String userId, String password) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.age = age;
	this.gender = gender;
	this.contactNo = contactNo;
	this.userId = userId;
	this.password = password;
}

@NotNull @Min(18) @Max(100)
private Integer age;
public User(String userId, String password) {
	super();
	this.userId = userId;
	this.password = password;
}

public User() {
	super();
}


private Gender gender;
@NotNull
@NotEmpty
private String contactNo;
@Id
@NotNull
@NotEmpty
private String userId;
@NotNull
@NotEmpty
private String password;

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}



public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public Gender getGender() {
	return gender;
}

public void setGender(Gender gender) {
	this.gender = gender;
}

public String getContactNo() {
	return contactNo;
}

public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public enum Gender{
	MALE,FEMALE;
}
}
