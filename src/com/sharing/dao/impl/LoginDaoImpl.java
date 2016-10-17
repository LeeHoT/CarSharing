package com.sharing.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharing.dao.LoginDao;
import com.sharing.entities.User;
import com.sharing.entities.dto.LoginDto;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SessionFactory sessionFactory;
	Query query = null;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public User login(LoginDto loginDto) {
		String hql = "FROM User u WHERE u.username = ? and u.password = ?";
		query = getSession().createQuery(hql)
				.setString(0, loginDto.getUsername())
				.setString(1, loginDto.getPassword());	
		return (User) query.uniqueResult();
	}

}
