package com.sharing.entities;

import org.springframework.stereotype.Repository;

/**
 * @author leehot 地址信息 其中 provinceId 为Province表的主键 cityId 为 City表的主键
 */
@Repository
public class Address {
	private Integer id;
	private Integer userId; // 用户id
	private boolean isDefault;// 是否是默认地址
	private Integer provinceId;// 外键 Province表的主键
	private Integer cityId;// 外键 City表的主键
	private String detailAdd;// 详细地址，包括街道、小区、门牌号等等

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

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getDetailAdd() {
		return detailAdd;
	}

	public void setDetailAdd(String detailAdd) {
		this.detailAdd = detailAdd;
	}

}
