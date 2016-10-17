package com.sharing.dao;

import java.util.List;

import com.sharing.entities.JoinDetail;

public interface JoinDetailDao {
	
	public int saveJoinDetail(JoinDetail joinDetail);
	
	public int updateJoinDetail(JoinDetail joinDetail);
	
	/**
	 * 删除已经过时的参与详情或者还未找到匹配着的信息
	 * @param Id  参与详情的Id
	 * @return  返回删除的行数，>0 删除成功，否则删除失败
	 */
	public int deleteJoinDetail(int Id);
	
	public List<JoinDetail> selectJoinDetailById(int userId);
	

	/**
	 * 检查查询id的详细信息是否存在
	 * @param id 查询id
	 * @return  返回查询到的id,否则为0
	 */
	public int selectJoinDetailId(int id);

}
