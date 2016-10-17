package com.sharing.entities;

import org.springframework.stereotype.Repository;

/**
 * @author leehot 市 固定在数据库中的某些值
 */
@Repository
public class City {
	private Integer id;
	private Integer provinceId;
	private String city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
