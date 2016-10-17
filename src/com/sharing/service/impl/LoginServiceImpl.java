package com.sharing.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.sharing.dao.LoginDao;
import com.sharing.entities.User;
import com.sharing.entities.dto.LoginDto;
import com.sharing.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	private User user;

	@Override
	public boolean login(LoginDto loginDto) {
		user = loginDao.login(loginDto);
		if (user != null) {
			System.out.println(user.getUsername() + "登录成功");
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> session = actionContext.getSession();
			//把用户名和id保存在session中
			session.put("id", user.getId());
			session.put("username", user.getUsername());
			return true;
		} else {
			System.out.println("登录失败");
			return false;
		}
	}

}
