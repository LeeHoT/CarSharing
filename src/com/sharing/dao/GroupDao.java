package com.sharing.dao;

import java.util.List;

import com.sharing.entities.Groups;

public interface GroupDao {
	/**
	 * 查询未分满的小组信息，，包括小组id及其中一人的id
	 * @param exceptPeople 根据期待人数确定分组信息
	 * @return  list.size()>0 ,则通过迭代进行匹配，若；list.size()<0，代表所有已参与人员获得足够分组
	 * @description 此处为默认每辆车均乘坐四人，获取到的未分满小组信息均为不足四人的小组
	 */
	public List<Groups> selectUnderGroup(int exceptPeople);
	
	public List<Groups> selectGroupByUserId(int userId);
	
	public List<Groups> selectGroup();
	
	public int delectGroupById(int groupId);
	
	/**
	 * 匹配两个用户的参与信息是否一致，包括用户的县级市，终点详细信息，终到时间和出发时间的最后期限(上下相差10分钟可以接受)，参与时间
	 * @param userId1
	 * @param userId2
	 * @return  true 表示匹配，否则匹配不成功
	 */
	public boolean matchJoinDetailInfo(int userId1,int userId2);
	
	
	/**
	 * 根据两个用户的id屁陪期望载客人数是否相同
	 * @param userId1  当前添加分组的用户id
	 * @param userId2  已经分配好的用户的id
	 * @return  true 表示匹配，否则匹配不成功
	 */
	public boolean matchExceptPeople(int userId1,int userId2);
	
	/**
	 * 获取当前最大分组的id,从而确定下一个新的分组的id
	 * @return 当前id值最大的分组的id值
	 */
	public int selectMaxGroupId();
	
	/**
	 * 保存分组信息
	 * @param groupId
	 * @param userId
	 * @return  返回值大于0,表明保存成功，否则保存失败
	 */
	public int saveGroup(int groupId,int userId,boolean isDrived);

}
