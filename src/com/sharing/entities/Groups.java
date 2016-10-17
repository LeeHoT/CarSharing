package com.sharing.entities;

import org.springframework.stereotype.Repository;

@Repository
public class Groups{
	private Integer id;
	private Integer groupId; //分组id
	private Integer userId; //用户id
	private boolean isDrived;// 是否已经开过车。。在一个轮回之内的时间 ，即4天

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean isDrived() {
		return isDrived;
	}

	public void setDrived(boolean isDrived) {
		this.isDrived = isDrived;
	}

}
