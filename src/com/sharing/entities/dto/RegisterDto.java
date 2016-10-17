package com.sharing.entities.dto;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

/**
 * @author leehot
 * 用于用户注册使用，包含  1. 注册信息   2.个人基本信息  3.车辆信息
 * 其中sex(性别)在数据库中仅存 0(女)和1(男)
 * 身份证号为18位
 * 电话号为11位
 */
@Repository(value="registerDto")
public class RegisterDto implements Serializable{
	private static final long serialVersionUID = -1386406530053458813L;
	/**
	 * 登录需要的信息，包括用户名 ,密码
	 */
	private String username;
	private String password_first;
	private String password_second;
	
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
	
	/**
	 * 个人汽车基本信息
	 * 包括 1。品牌  2.型号  3.车牌号  4.车型   5.驾驶证号  6.行驶证号  7.期望载客人数
	 */
	private String brand;//品牌
	private String model;//汽车型号
	private String licenseNum;//车牌号码
	private String motorcycleType;//车型
	private String drivingLicenseNum;//驾驶证号
	private String registrationNum;//行驶证号
	private Integer expectPeopleNum;// 期望载客人数

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword_first() {
		return password_first;
	}

	public void setPassword_first(String password_first) {
		this.password_first = password_first;
	}

	public String getPassword_second() {
		return password_second;
	}

	public void setPassword_second(String password_second) {
		this.password_second = password_second;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getMotorcycleType() {
		return motorcycleType;
	}

	public void setMotorcycleType(String motorcycleType) {
		this.motorcycleType = motorcycleType;
	}

	public String getDrivingLicenseNum() {
		return drivingLicenseNum;
	}

	public void setDrivingLicenseNum(String drivingLicenseNum) {
		this.drivingLicenseNum = drivingLicenseNum;
	}

	public String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	public Integer getExpectPeopleNum() {
		return expectPeopleNum;
	}

	public void setExpectPeopleNum(Integer expectPeopleNum) {
		this.expectPeopleNum = expectPeopleNum;
	}
	
	

}
