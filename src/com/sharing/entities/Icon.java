package com.sharing.entities;

import org.springframework.stereotype.Repository;

@Repository
public class Icon {

	private int userId;  //用户id
	private String iconName;  //头像名称

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

}
