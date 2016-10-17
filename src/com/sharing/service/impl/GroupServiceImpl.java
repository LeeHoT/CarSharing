package com.sharing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharing.dao.GroupDao;
import com.sharing.entities.Groups;
import com.sharing.entities.dto.GroupDto;
import com.sharing.service.GroupService;
import com.sharing.service.JoinDetailService;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;
	@Autowired
	private JoinDetailService joinDetailService;

	@Override
	public int divideGroup(int userId) {
		int res = 0;
		boolean isMatched = false;
		// lg存有多组groupId 和userId组成的数据
		List<Groups> lg = groupDao.selectUnderGroup(4);
		System.out.println("为分满小组的个数： "+lg.size());
		if (lg.size() > 0) {
			// 此处控制台应输出0-多组 期望人数不匹配，至多会输出一组匹配成功
			for (Groups g : lg) {
				// 匹配期望人数是否一样
				if (groupDao.matchExceptPeople(userId, g.getUserId())) {
					// 期望人数一样。则匹配地址信息
					// 取出当前用户的地址和与之匹配的用户地址
					isMatched = joinDetailService.matchJoinDetail(userId, g.getUserId());
					if (isMatched) {
						// 地址信息一致
						System.out.println("地址信息匹配成功");
						res = saveGroup(userId, g.getGroupId());
						return res;
					} else {
						System.out.println("地址信息不一致");
					}
				} else {
					// 期望人数不匹配，
					System.out.println("期望人数不匹配");
				}
			}
			if (!isMatched) {
				int max = groupDao.selectMaxGroupId();
				res = saveGroup(userId, max + 1);
			}
		} else {
			// 没有结果，则直接新开一组
			// 首先获取当前最大分组
			int max = groupDao.selectMaxGroupId();
			res = saveGroup(userId, max + 1);
		}
		return res;
	}

	@Override
	public int saveGroup(int userId, int groupId) {
		// 因为是新加入，所以默认未开过车
		int res = groupDao.saveGroup(groupId, userId, false);
		if (res > 0) {
			// 添加分组成功
			System.out.println("添加分组成功");
		} else {
			System.out.println("添加分组失败");
			return -1;
		}

		return res;
	}

	@Override
	public int deleteGroup(int groupId) {
		int res = groupDao.delectGroupById(groupId);
		return res;
	}

	@Override
	public int changeGroup(GroupDto groupDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GroupDto> selectGroupByUserId(int userId) {
		List<Groups> lg = groupDao.selectGroupByUserId(userId);
		List<GroupDto> list = new ArrayList<GroupDto>();
		for (Groups g : lg) {
			GroupDto groupDto = new GroupDto();
			groupDto.setId(g.getId());
			groupDto.setGroupId(g.getGroupId());
			groupDto.setUserId(g.getUserId());
			groupDto.setIsDriving(g.isDrived());
			list.add(groupDto);
		}
		return list;
	}

	@Override
	public List<GroupDto> selectGroup() {
		List<Groups> lg = groupDao.selectGroup();
		List<GroupDto> list = new ArrayList<GroupDto>();
		for (Groups g : lg) {
			GroupDto groupDto = new GroupDto();
			groupDto.setId(g.getId());
			groupDto.setGroupId(g.getGroupId());
			groupDto.setUserId(g.getUserId());
			groupDto.setIsDriving(g.isDrived());
			list.add(groupDto);
		}
		return list;
	}

}
