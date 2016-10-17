package com.sharing.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sharing.dao.JoinDetailDao;
import com.sharing.entities.JoinDetail;

public class JoinDetaliDaoImpl implements JoinDetailDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	Query query = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int saveJoinDetail(JoinDetail joinDetail) {
		String ssql = "insert into joinDetail(userId,startingPoint,terminalPoint,goOff_first,goOff_second,"
				+ "arrivalTime_first,arrivalTime_second,participateTime_first,participateTime_second) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		query = getSession().createSQLQuery(ssql);
		query.setInteger(0, joinDetail.getUserId());
		query.setString(1, joinDetail.getStartingPoint());
		query.setString(2, joinDetail.getTerminalPoint());
		query.setString(3, joinDetail.getGoOff_first());
		query.setString(4, joinDetail.getGoOff_second());
		query.setString(5, joinDetail.getArrivalTime_first());
		query.setString(6, joinDetail.getArrivalTime_second());
		query.setString(7, joinDetail.getParticipateTime_first());
		query.setString(8, joinDetail.getParticipateTime_second());
		int res = query.executeUpdate();
		return res;//返回更新行数 >0 添加成功
	}

	@Override
	public int updateJoinDetail(JoinDetail joinDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteJoinDetail(int id) {
		String hql = "delete from JoinDetail j where j.id = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, id);
		int res = query.executeUpdate();
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JoinDetail> selectJoinDetailById(int userId) {
		String hql = "from JoinDetail j where j.userId = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, userId);
		List<JoinDetail> list = query.list();
		return list;
	}

	@Override
	public int selectJoinDetailId(int id) {
		String hql = "select j.id from JoinDetail j where j.id = ?";
		query = getSession().createQuery(hql);
		query.setInteger(0, id);
		int res =(int) query.uniqueResult();
		return res;
	}

}
