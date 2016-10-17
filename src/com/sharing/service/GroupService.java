package com.sharing.service;

import java.util.List;

import com.sharing.entities.dto.GroupDto;

public interface GroupService {
	
	public int divideGroup(int userId);
	
	public int saveGroup(int userId,int groupId);
	
	public int deleteGroup(int groupId);
	
	public int changeGroup(GroupDto groupDto);
	
	public List<GroupDto> selectGroupByUserId(int userId);
	
	public List<GroupDto> selectGroup();

}
