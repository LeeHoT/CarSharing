package com.sharing.entities.dto;

import org.springframework.stereotype.Repository;

@Repository
public class GroupDto {
	
	private Integer id;
	private Integer groupId;
	private Integer userId;
	private Boolean isDrived;

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

	public Boolean getIsDriving() {
		return isDrived;
	}

	public void setIsDriving(Boolean isDriving) {
		this.isDrived = isDriving;
	}
	
	
	

}
