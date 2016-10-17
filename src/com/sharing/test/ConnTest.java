package com.sharing.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ConnTest {
	
	private ApplicationContext ctx = null;
	//private LoginService userService = null;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//userService = ctx.getBean(LoginService.class);
	}

	@Test
	public void testDataSource() throws SQLException {

		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}


}
