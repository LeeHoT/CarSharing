package com.sharing.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionUtil {	
	public Session getSession(SessionFactory sessionFactory){
		return sessionFactory.getCurrentSession();
	}

}
