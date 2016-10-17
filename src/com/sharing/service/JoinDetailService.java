package com.sharing.service;

import java.util.List;

import com.sharing.entities.dto.JoinDetailDto;

public interface JoinDetailService {
	
	public int saveJoinDetail(JoinDetailDto joinDetailDto);

	public int deleteJoinDetail(int id);

	public int updateJoinDetail(JoinDetailDto joinDetailDto);

	public List<JoinDetailDto> selectJoinDetailById(int userId);
	
	public boolean matchJoinDetail(int userId,int userId2);
	
}
