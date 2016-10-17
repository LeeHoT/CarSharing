package com.sharing.entities.dto;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author leehot
 * 用于用户登录  用户输入用户名及密码  正确后方可登录
 */
@Repository(value="loginDto")
public class LoginDto implements Serializable {

	private static final long serialVersionUID = -3896453586861873327L;

	private String username;// 用户名
	private String password;// 登录密码

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
