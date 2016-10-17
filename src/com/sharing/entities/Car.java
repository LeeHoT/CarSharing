package com.sharing.entities;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class Car implements Serializable {

	private static final long serialVersionUID = -7469392181863831431L;
	/**
	 * 个人汽车基本信息 包括 1。品牌 2.型号 3.车牌号 4.车型 5.驾驶证号 6.行驶证号 7.期望载客人数
	 */
	private Integer id;
	private Integer userId;//车主
	private String brand;// 品牌
	private String model;// 汽车型号
	private String licenseNum;// 车牌号码
	private String motorcycleType;// 车型
	private String drivingLicenseNum;// 驾驶证号
	private String registrationNum;// 行驶证号
	private Integer expectPeopleNum;// 期望载客人数

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
