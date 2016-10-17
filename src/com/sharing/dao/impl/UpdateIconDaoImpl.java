package com.sharing.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sharing.dao.UpdateIconDao;
import com.sharing.entities.Icon;

public class UpdateIconDaoImpl implements UpdateIconDao {

	@Autowired
	private SessionFactory sessionFactory;
	Query query = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int updateIcon(Icon icon) {
		String hql = "update Icon i set i.iconName = ? where i.userId = ?";
		query = getSession().createQuery(hql);
		query.setString(0, icon.getIconName());
		query.setInteger(1, icon.getUserId());
		int res = query.executeUpdate();
		return res;
	}

}
