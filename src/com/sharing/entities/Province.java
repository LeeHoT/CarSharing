package com.sharing.entities;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author leehot
 * 省份信息  固定在数据库中的内容
 *
 */
@Repository
public class Province {
	private Integer id;
	private String province;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
