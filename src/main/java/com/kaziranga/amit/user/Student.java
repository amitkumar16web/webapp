package com.kaziranga.amit.user;

public class Student {

	String name;
	
	String mobile;
	
	String branch;
	
	String sem;

	String email;

	String password_1;

	public Student(String name,String mobile,String branch,String sem, String email, String password) {
		this.name= name;
		this.mobile= mobile;
		this.branch= branch;
		this.sem= sem;
		this.email= email;
		this.password_1= password;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword_1() {
		return password_1;
	}

	public void setPassword_1(String password_1) {
		this.password_1 = password_1;
	}

}
