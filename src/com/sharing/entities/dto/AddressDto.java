package com.sharing.entities.dto;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository(value="addressDto")
public class AddressDto implements Serializable {
	private static final long serialVersionUID = -1327960872459076395L;
	private Integer id;
	private Integer userId; // 用户id
	private boolean isDefault;// 是否是默认地址， 默认为false,如果只有一个。则为true
	private String province;// 用户所在省
	private String city;// 用户所在市
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDetailAdd() {
		return detailAdd;
	}

	public void setDetailAdd(String detailAdd) {
		this.detailAdd = detailAdd;
	}

}
