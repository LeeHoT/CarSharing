package com.sharing.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sharing.entities.dto.GroupDto;
import com.sharing.service.GroupService;

@Controller("groupAction")
public class GroupAction extends ActionSupport {

	private static final long serialVersionUID = -7373646097396903250L;

	@Autowired
	private GroupService groupService;

	private List<GroupDto> list = new ArrayList<>();
	private Integer userId;
	private Integer groupId;
	private GroupDto groupDto;

	public String divideGroup() {
		int result;
		if (userId != null) {
			result = groupService.divideGroup(userId);
		} else {
			result = groupService.divideGroup(groupDto.getUserId());
		}
		if (result > 0) {
			return SUCCESS;
		}
		return INPUT;
	}

	public String selectGroup() {
		list = groupService.selectGroup();
		if (list.size() > 0) {
			return SUCCESS;
		}
		return INPUT;
	}

	public String deleteGroup() {
		int result;
		if (groupId != null) {
			result = groupService.deleteGroup(groupId);
		}else{
			result = groupService.deleteGroup(groupDto.getGroupId());
		}
		
		if (result > 0) {
			return SUCCESS;
		}
		return INPUT;
	}

	public String selectGroupByUserId() {
		list = groupService.selectGroup();
		if (list.size() > 0) {
			return SUCCESS;
		}
		return INPUT;
	}

	public List<GroupDto> getList() {
		return list;
	}

	public void setList(List<GroupDto> list) {
		this.list = list;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public GroupDto getGroupDto() {
		return groupDto;
	}

	public void setGroupDto(GroupDto groupDto) {
		this.groupDto = groupDto;
	}
}
