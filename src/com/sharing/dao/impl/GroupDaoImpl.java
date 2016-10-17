package com.sharing.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sharing.dao.GroupDao;
import com.sharing.entities.Groups;

public class GroupDaoImpl implements GroupDao {

	@Autowired
	private SessionFactory sessionFactory;
	Query query = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groups> selectGroupByUserId(int userId) {
		String sql = "SELECT * FROM groups WHERE groupId = " + "(SELECT groupId FROM groups WHERE userId = ?)";
		query = getSession().createSQLQuery(sql);
		query.setInteger(0, userId);
		List<Groups> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groups> selectGroup() {
		String hql = "from Groups g";
		query = getSession().createQuery(hql);
		List<Groups> list = query.list();
		return list;
	}

	@Override
	public int delectGroupById(int groupId) {
		String hql = "DELETE FROM Groups g where g.groupId = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, groupId);
		int res = query.executeUpdate();
		return res;
	}

	@Override
	public List<Groups> selectUnderGroup(int expectPeople) {
		System.out.println("GroupDao expectPeople: " + expectPeople);
		// 查询未分满的小组
		String hql = "FROM Groups g GROUP BY g.groupId HAVING COUNT(g.groupId)<?";
		query = getSession().createQuery(hql);
		query.setInteger(0, expectPeople);
		@SuppressWarnings("unchecked")

		List<Groups> underGroup = query.list();
		System.out.println("underGroup : " + underGroup);
		return underGroup;
	}

	@Override
	public boolean matchJoinDetailInfo(int userId1, int userId2) {
		String hql = "SELECT userId FROM JoinDetail where userId = ? and  ";
		return true;
	}

	@Override
	public boolean matchExceptPeople(int userId1, int userId2) {
		String sql = "SELECT userId FROM car WHERE userId = ? AND expectPeopleNum =(SELECT expectPeopleNum FROM car WHERE userId = ?)";
		query = getSession().createSQLQuery(sql);
		query.setInteger(0, userId2);
		query.setInteger(1, userId1);
		System.out.println("query:　" + query);

		List<Integer> userId = query.list();
		
//		int userId = 0;
//		userId = (int) query.uniqueResult();
//		System.out.println(userId);
		if (userId.size()> 0) {
			System.out.println("大小 : " +userId.size() );
			return true;
		}
		System.out.println("结果为空，，匹配不成功");
		return false;
	}

	@Override
	public int selectMaxGroupId() {
		String hql = "SELECT MAX(g.groupId) FROM Groups g";
		query = getSession().createQuery(hql);
		int res = (int) query.uniqueResult();
		return res;
	}

	@Override
	public int saveGroup(int groupId, int userId, boolean isDrived) {
		String sql = "INSERT INTO groups(groupId,userId,isDrived) VALUE(?,?,?);";
		query = getSession().createSQLQuery(sql);
		query.setInteger(0, groupId);
		query.setInteger(1, userId);
		query.setBoolean(2, isDrived);
		int res = query.executeUpdate();
		return res;
	}
}
