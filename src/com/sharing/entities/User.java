package com.sharing.entities;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class User implements Serializable {
	private static final long serialVersionUID = 7217030188708117396L;
	private int id;
	private String username;
	private String password;
	/*
	 * 用户基本信息  
	 * 包括  1.用户真实姓名  2.性别  3.出生年月  4.身份证号  5.电话号  6.职业  7 邮箱  
	 */
	private String realName;
	private String sex;
	private String birthday;
	private String idCard;
	private String profession;//职业
	private String phoneNum;//电话号
	private String email;//邮箱

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
